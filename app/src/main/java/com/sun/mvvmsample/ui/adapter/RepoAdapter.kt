package com.sun.mvvmsample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sun.mvvmsample.R
import com.sun.mvvmsample.data.model.GithubRepo
import com.sun.mvvmsample.data.model.RepoItemCallBack
import com.sun.mvvmsample.databinding.ItemRepoBinding
import com.sun.mvvmsample.ui.base.BaseRecyclerAdapter
import com.sun.mvvmsample.ui.base.BaseViewHolder

class RepoAdapter(
    private val onItemClick: (GithubRepo) -> Unit
) : BaseRecyclerAdapter<GithubRepo, RepoViewHolder>(RepoItemCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val binding = DataBindingUtil.inflate<ItemRepoBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_repo,
            parent,
            false
        )
        return RepoViewHolder(binding, onItemClick)
    }
}

class RepoViewHolder(
    private val binding: ItemRepoBinding,
    onItemClick: (GithubRepo) -> Unit
) : BaseViewHolder<GithubRepo>(binding.root, onItemClick) {

    override fun bindData(item: GithubRepo) {
        super.bindData(item)
        binding.repo = item
    }
}
