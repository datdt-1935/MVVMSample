package com.sun.mvvmsample.data.source

import com.sun.mvvmsample.coroutine.CoroutineResult
import com.sun.mvvmsample.data.source.remote.response.GithubRepoResponse

interface GithubRepoDataSource {
    interface Local

    interface Remote {
        suspend fun getRepos(
            query: String,
            page: Int,
            perPage: Int
        ): CoroutineResult<GithubRepoResponse>
    }
}
