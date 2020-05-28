package com.sun.mvvmsample.di

import java.sql.ClientInfoStatus

object KoinNames {

    // Api
    const val REPO_API = "name_repo_api"
    const val CLIENT = "name_client"
    const val GSON_CONVERTER_FACTORY = "name_gson_converter_factory"
    const val COROUTINE_CALL_ADAPTER_FACTORY = "name_coroutine_call_adapter_factory"

    // DataSource
    const val REPO_LOCAL_DATASOURCE = "name_repo_local_datasource"
    const val REPO_REMOTE_DATASOURCE = "name_repo_remote_datasource"

    // Repository
    const val REPO_REPOSITORY = "name_repo_repository"
}
