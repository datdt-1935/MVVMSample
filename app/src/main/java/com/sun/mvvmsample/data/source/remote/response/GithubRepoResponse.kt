package com.sun.mvvmsample.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.sun.mvvmsample.data.model.GithubRepo

data class GithubRepoResponse(
    @SerializedName("items")
    val items: List<GithubRepo>
)
