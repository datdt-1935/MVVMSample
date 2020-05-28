package com.sun.mvvmsample

import android.app.Application
import com.sun.mvvmsample.di.apiModule
import com.sun.mvvmsample.di.sourceModule
import com.sun.mvvmsample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GithubApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@GithubApp)
            modules(listOf(apiModule, sourceModule, viewModelModule))
        }
    }
}
