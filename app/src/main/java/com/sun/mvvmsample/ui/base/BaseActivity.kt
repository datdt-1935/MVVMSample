package com.sun.mvvmsample.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.sun.mvvmsample.extension.showToast
import com.sun.mvvmsample.util.Constants

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {

    @get:LayoutRes
    protected abstract val layoutResource: Int
    protected abstract val viewModel: VM
    protected var loadMore = true
    protected lateinit var viewDataBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
        initComponents()
        initData()
        observeData()
    }

    protected open fun initData() {
        viewModel.create()
    }

    protected abstract fun initComponents()

    protected open fun observeData() {
        viewModel.messageNotification.observe(this, Observer {
            if (it == Constants.MESSAGE_DATA_NOT_FOUND)
                loadMore = false
            showToast(it)
        })
    }

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutResource)
    }
}
