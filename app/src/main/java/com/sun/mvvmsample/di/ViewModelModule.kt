package com.sun.mvvmsample.di

import com.sun.mvvmsample.ui.screen.detail.DetailViewModel
import com.sun.mvvmsample.ui.screen.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(named(KoinNames.REPO_REPOSITORY))) }

    viewModel { DetailViewModel() }
}
