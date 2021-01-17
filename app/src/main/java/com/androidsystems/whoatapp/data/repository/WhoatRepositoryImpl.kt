package com.androidsystems.whoatapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidsystems.whoatapp.data.network.ReportsDataSource
import com.androidsystems.whoatapp.data.network.response.ReportsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WhoatRepositoryImpl(private val dataSource: ReportsDataSource) : WhoatRepository {

    private val _downloadedReports = MutableLiveData<ReportsResponse>()

    init {
        dataSource.downloadedReport.observeForever { response ->
            _downloadedReports.postValue(response)
        }
    }

    override suspend fun getReports(location: String): LiveData<ReportsResponse> {
        dataSource.fetchReport(location)
        return withContext(Dispatchers.IO) {
            return@withContext _downloadedReports
        }
    }
}