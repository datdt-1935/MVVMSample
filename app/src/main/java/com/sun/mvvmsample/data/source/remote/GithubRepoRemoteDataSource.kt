package com.sun.mvvmsample.data.source.remote

import com.sun.mvvmsample.coroutine.CoroutineResult
import com.sun.mvvmsample.data.api.RepoApi
import com.sun.mvvmsample.data.source.GithubRepoDataSource
import com.sun.mvvmsample.data.source.remote.response.GithubRepoResponse
import com.sun.mvvmsample.extension.awaitResult

class GithubRepoRemoteDataSource(private val repoApi: RepoApi) : GithubRepoDataSource.Remote {

    override suspend fun getRepos(
        query: String,
        page: Int,
        perPage: Int
    ): CoroutineResult<GithubRepoResponse> =
        repoApi.getRepos(query, page, perPage).awaitResult()
}
