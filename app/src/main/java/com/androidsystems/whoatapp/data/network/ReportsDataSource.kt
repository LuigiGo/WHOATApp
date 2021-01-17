package com.androidsystems.whoatapp.data.network

import androidx.lifecycle.LiveData
import com.androidsystems.whoatapp.data.network.response.ReportsResponse

interface ReportsDataSource {
    val downloadedReport: LiveData<ReportsResponse>

    suspend fun fetchReport(location: String)
}