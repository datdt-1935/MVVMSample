package com.sun.mvvmsample.ui.screen.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sun.mvvmsample.coroutine.CoroutineResult
import com.sun.mvvmsample.data.model.GithubRepo
import com.sun.mvvmsample.data.repository.GithubRepoRepositoryType
import com.sun.mvvmsample.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel(private val repository: GithubRepoRepositoryType) : BaseViewModel() {

    val repos: LiveData<List<GithubRepo>>
        get() = _repos

    private val _repos = MutableLiveData<List<GithubRepo>>()

    private val repoList = mutableListOf<GithubRepo>()

    fun getRepos(query: String, page: Int, perPage: Int) = launch {
        when (val result = repository.getRepos(query, page, perPage)) {
            is CoroutineResult.Success -> repoList.addAll(result.data.items)
            is CoroutineResult.Error -> {
                messageNotification.value = result.throwable.message.toString()
                repoList.addAll(emptyList())
            }
        }
        _repos.value = repoList
    }

    fun refreshNewRepos(query: String, page: Int, perPage: Int) {
        repoList.clear()
        getRepos(query, page, perPage)
    }

    override fun create() {
    }
}
