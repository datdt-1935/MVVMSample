package com.sun.mvvmsample.ui.screen.main

import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.sun.mvvmsample.R
import com.sun.mvvmsample.databinding.ActivityMainBinding
import com.sun.mvvmsample.ui.adapter.RepoAdapter
import com.sun.mvvmsample.ui.base.BaseActivity
import com.sun.mvvmsample.ui.component.ItemSpaceDecoration
import com.sun.mvvmsample.ui.component.LoadMoreListener
import com.sun.mvvmsample.ui.screen.detail.DetailActivity
import com.sun.mvvmsample.util.Constants
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutResource: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel by viewModel()

    private var page = Constants.DEFAULT_PAGE
    private val repoAdapter by lazy {
        RepoAdapter {
            startActivity(DetailActivity.getIntent(this, it))
        }
    }

    override fun initComponents() {
        initRecyclerView()
        initSwipeRefreshLayout()
    }

    override fun initData() {
        super.initData()
        refreshNewRepos()
    }

    override fun observeData() {
        super.observeData()
        viewModel.repos.observe(this, Observer {
            it?.let {
                repoAdapter.submitList(it)
            }
        })
    }

    private fun initRecyclerView() {
        recyclerViewPhoto.apply {
            adapter = repoAdapter
            hasFixedSize()
            addItemDecoration(ItemSpaceDecoration(10, 20, 10, 20))
            addOnScrollListener(object : LoadMoreListener() {
                override fun onLastItemVisible() {
                    if (loadMore)
                        getRepos()
                }
            })
        }
    }

    private fun initSwipeRefreshLayout() {
        repoSwipeRefreshLayout.apply {
            setOnRefreshListener {
                refreshNewRepos()
                isRefreshing = false
            }
        }
    }

    private fun refreshNewRepos() {
        page = Constants.DEFAULT_PAGE
        loadMore = true
        viewModel.refreshNewRepos("language:kotlin", page, Constants.DEFAULT_PER_PAGE)
    }

    private fun getRepos() {
        viewModel.getRepos("language:kotlin", ++page, Constants.DEFAULT_PER_PAGE)
    }
}
