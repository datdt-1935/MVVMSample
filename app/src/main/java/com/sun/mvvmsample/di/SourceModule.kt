package com.sun.mvvmsample.di

import com.sun.mvvmsample.data.repository.GithubRepoRepository
import com.sun.mvvmsample.data.source.local.GithubRepoLocalDataSource
import com.sun.mvvmsample.data.source.remote.GithubRepoRemoteDataSource
import org.koin.core.qualifier.named
import org.koin.dsl.module

val sourceModule = module {

    single(named(KoinNames.REPO_REPOSITORY)) {
        GithubRepoRepository(
            get(named(KoinNames.REPO_LOCAL_DATASOURCE)),
            get(named(KoinNames.REPO_REMOTE_DATASOURCE))
        )
    }

    single(named(KoinNames.REPO_LOCAL_DATASOURCE)) {
        GithubRepoLocalDataSource()
    }

    single(named(KoinNames.REPO_REMOTE_DATASOURCE)) {
        GithubRepoRemoteDataSource(get(named(KoinNames.REPO_API)))
    }
}
