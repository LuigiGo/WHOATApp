package com.androidsystems.whoatapp.data.repository

import androidx.lifecycle.LiveData
import com.androidsystems.whoatapp.data.network.response.ReportsResponse

interface WhoatRepository {
    suspend fun getReports(location: String): LiveData<ReportsResponse>
}