package com.sun.mvvmsample.ui.screen.detail

import android.content.Context
import android.content.Intent
import android.view.View
import com.sun.mvvmsample.R
import com.sun.mvvmsample.data.model.GithubRepo
import com.sun.mvvmsample.databinding.ActivityDetailBinding
import com.sun.mvvmsample.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {
    override val layoutResource: Int
        get() = R.layout.activity_detail

    override val viewModel: DetailViewModel by viewModel()

    private var repo: GithubRepo? = null

    override fun initComponents() {
        initToolbar()
    }

    override fun initData() {
        super.initData()
        repo = intent.getParcelableExtra(EXTRA_REPO)
    }

    override fun observeData() {
        super.observeData()
        viewDataBinding.repoDetail = repo
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun initToolbar() {
        toolbar.setNavigationOnClickListener { onBackPressed() }
        setSupportActionBar(viewDataBinding.toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    companion object {
        private const val EXTRA_REPO = "repo"
        fun getIntent(context: Context, repo: GithubRepo) =
            Intent(context, DetailActivity::class.java)
                .putExtra(EXTRA_REPO, repo)
    }
}
