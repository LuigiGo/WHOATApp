package com.androidsystems.whoatapp.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidsystems.whoatapp.data.network.response.ReportsResponse
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.*
import org.mockito.*
import org.mockito.Mockito.*
import org.mockito.junit.*

@RunWith(MockitoJUnitRunner::class)
class WhoatRepositoryImplTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var whoatRepository: WhoatRepository

    @Mock
    private lateinit var _downloadedReports: MutableLiveData<ReportsResponse>


    @Test
    fun getReports_hasCorrectResponse() {
        runBlocking {
            `when`(whoatRepository.onReportsLoaded("test")).thenReturn(_downloadedReports)
            val result = whoatRepository.onReportsLoaded("test")

            assertThat(result).isEqualTo(_downloadedReports)
            assertThat(result).isInstanceOf(LiveData::class.java)
            assertThat(result).isNotNull()
        }
    }

    @Test
    fun getReports_hasInvalidResponse() {
        runBlocking {
            `when`(whoatRepository.onReportsLoaded("test")).thenReturn(null)
            val result = whoatRepository.onReportsLoaded("test")
            assertThat(result).isNull()
        }
    }
}