package com.androidsystems.whoatapp.data.repository

import androidx.lifecycle.LiveData
import com.androidsystems.whoatapp.data.network.response.ReportsResponse

interface WhoatRepository {
    suspend fun loadReports(location: String)
    suspend fun onReportsLoaded(): LiveData<ReportsResponse>
}