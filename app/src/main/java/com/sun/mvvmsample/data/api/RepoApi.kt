package com.sun.mvvmsample.data.api

import com.sun.mvvmsample.data.source.remote.response.GithubRepoResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoApi {

    @GET(ApiConstants.SEARCH_URL)
    fun getRepos(
        @Query(QUERY) query: String,
        @Query(QUERY_PAGE) page: Int,
        @Query(QUERY_PER_PAGE) perPage: Int
    ): Deferred<GithubRepoResponse>
}
