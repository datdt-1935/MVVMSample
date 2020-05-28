package com.sun.mvvmsample.di

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.sun.mvvmsample.data.api.ApiConstants
import com.sun.mvvmsample.data.api.ApiFactory
import com.sun.mvvmsample.data.api.RepoApi
import com.sun.mvvmsample.util.Constants
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {

    single(named(KoinNames.REPO_API)) {
        ApiFactory.buildApi(
            baseUrl = ApiConstants.BASE_URL,
            restApi = RepoApi::class.java,
            client = get(named(KoinNames.CLIENT)),
            converterFactory = get(named(KoinNames.GSON_CONVERTER_FACTORY)),
            callAdapterFactory = get(named(KoinNames.COROUTINE_CALL_ADAPTER_FACTORY))
        )
    }

    single(named(KoinNames.CLIENT)) {
        OkHttpClient.Builder().build()
    }

    single(named(KoinNames.COROUTINE_CALL_ADAPTER_FACTORY)) {
        CoroutineCallAdapterFactory()
    }

    single(named(KoinNames.GSON_CONVERTER_FACTORY)) {
        GsonConverterFactory.create()
    }
}
