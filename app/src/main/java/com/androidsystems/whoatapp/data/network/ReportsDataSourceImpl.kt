package com.androidsystems.whoatapp.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidsystems.whoatapp.data.network.base.NetworkModule
import com.androidsystems.whoatapp.data.network.response.ReportsResponse
import com.androidsystems.whoatapp.utilities.exceptions.NoConnectivityException

class ReportsDataSourceImpl(private val networkModule: NetworkModule) : ReportsDataSource {

    private val _downloadedReport = MutableLiveData<ReportsResponse>()

    override val downloadedReport: LiveData<ReportsResponse>
        get() = _downloadedReport

    override suspend fun fetchReport(location: String) {
        try {
            val fetchReport = networkModule.create().getReports(location).await()
            _downloadedReport.postValue(fetchReport)
        } catch (e: Exception) {
            if (e is NoConnectivityException) {
                Log.e("test", "No internet connection", e)
            } else {
                Log.e("test", "Unknown Exception")
            }
        }
    }
}