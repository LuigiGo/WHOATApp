package com.androidsystems.whoatapp.data.network

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidsystems.whoatapp.data.network.base.NetworkModule
import com.androidsystems.whoatapp.data.network.base.NetworkServiceApi
import com.androidsystems.whoatapp.data.network.response.ReportsResponse
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.*
import org.mockito.*
import org.mockito.Mockito.*
import org.mockito.junit.*

@RunWith(MockitoJUnitRunner::class)
class ReportsDataSourceImplTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var networkServiceApi: NetworkServiceApi

    @Mock
    private lateinit var reportsResponse: ReportsResponse

    @Mock
    private lateinit var networkModule: NetworkModule

    @Mock
    private lateinit var reportsDataSourceImpl: ReportsDataSourceImpl

    @Mock
    private lateinit var _downloadedReports: MutableLiveData<ReportsResponse>


    @Test
    fun fetchReport_hasCorrectResponse() {
        runBlocking {
            `when`(networkModule.create()).thenReturn(networkServiceApi)
            `when`(networkModule.create().getReports("test")).thenReturn(CompletableDeferred(reportsResponse))

            val result = reportsDataSourceImpl.fetchReport("test")

            assertThat(networkModule).isNotNull()
            assertThat(networkModule.create()).isNotNull()
            assertThat(networkModule.create().getReports("test")).isNotNull()
            assertThat(networkModule.create().getReports("test").await()).isInstanceOf(ReportsResponse::class.java)
            assertThat(result).isNotNull()
        }
    }

    @Test
    fun fetchReport_hasInvalidResponse() {
        runBlocking {
            `when`(networkModule.create()).thenReturn(networkServiceApi)
            `when`(networkModule.create().getReports("test")).thenReturn(null)

            reportsDataSourceImpl.fetchReport("test")

            assertThat(networkModule).isNotNull()
            assertThat(networkModule.create()).isNotNull()
            assertThat(networkModule.create().getReports("test")).isNull()
        }
    }

    @Test
    fun getDownloadedReport_hasCorrectData() {
        runBlocking {
            `when`(networkModule.create()).thenReturn(networkServiceApi)
            `when`(networkModule.create().getReports("test")).thenReturn(CompletableDeferred(reportsResponse))
            `when`(reportsDataSourceImpl.downloadedReport).thenReturn(_downloadedReports)

            val result = networkModule.create().getReports("test").await()
            _downloadedReports.postValue(result)

            assertThat(result).isNotNull()
            assertThat(result).isInstanceOf(ReportsResponse::class.java)
            assertThat(reportsDataSourceImpl.downloadedReport).isEqualTo(_downloadedReports)
            assertThat(reportsDataSourceImpl.downloadedReport).isInstanceOf(MutableLiveData::class.java)
        }
    }
}