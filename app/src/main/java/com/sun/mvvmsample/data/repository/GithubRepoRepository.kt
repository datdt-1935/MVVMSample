package com.sun.mvvmsample.data.repository

import com.sun.mvvmsample.coroutine.CoroutineResult
import com.sun.mvvmsample.data.source.GithubRepoDataSource
import com.sun.mvvmsample.data.source.remote.response.GithubRepoResponse

interface GithubRepoRepositoryType : GithubRepoDataSource.Local, GithubRepoDataSource.Remote

class GithubRepoRepository(
    private val local: GithubRepoDataSource.Local,
    private val remote: GithubRepoDataSource.Remote
) : GithubRepoRepositoryType {

    override suspend fun getRepos(
        query: String,
        page: Int,
        perPage: Int
    ): CoroutineResult<GithubRepoResponse> =
        remote.getRepos(query, page, perPage)
}
