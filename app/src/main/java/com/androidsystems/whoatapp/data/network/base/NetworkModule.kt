package com.androidsystems.whoatapp.data.network.base

import com.androidsystems.whoatapp.data.network.base.NetworkConstants.Companion.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModule(
    private val requestInterceptor: RequestInterceptor,
    private val connectivityInterceptor: ConnectivityInterceptor
) {

    fun create(): NetworkServiceApi {
        val logging = HttpLoggingInterceptor()
        logging.level = Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .addInterceptor(connectivityInterceptor)
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkServiceApi::class.java)
    }
}