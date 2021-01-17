package com.androidsystems.whoatapp.data.network.base

import com.androidsystems.whoatapp.data.network.base.NetworkConstants.Companion.REPORT_API
import com.androidsystems.whoatapp.data.network.response.ReportsResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkServiceApi {

    @GET(REPORT_API)
    fun getReports(
        @Query("where", encoded = true) iso: String
    ): Deferred<ReportsResponse>
}