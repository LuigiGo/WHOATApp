package com.androidsystems.whoatapp

import android.app.Application
import com.androidsystems.whoatapp.data.network.ReportsDataSource
import com.androidsystems.whoatapp.data.network.ReportsDataSourceImpl
import com.androidsystems.whoatapp.data.network.base.ConnectivityInterceptor
import com.androidsystems.whoatapp.data.network.base.ConnectivityInterceptorImpl
import com.androidsystems.whoatapp.data.network.base.NetworkModule
import com.androidsystems.whoatapp.data.network.base.RequestInterceptor
import com.androidsystems.whoatapp.data.network.base.RequestInterceptorImpl
import com.androidsystems.whoatapp.data.repository.WhoatRepository
import com.androidsystems.whoatapp.data.repository.WhoatRepositoryImpl
import com.androidsystems.whoatapp.ui.reports.ReportsViewModelFactory
import com.androidsystems.whoatapp.utilities.helpers.Conversions
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class WhoatApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@WhoatApplication))

        bind() from singleton { Conversions() }
        bind<RequestInterceptor>() with singleton { RequestInterceptorImpl() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { NetworkModule(instance(), instance()) }
        bind<ReportsDataSource>() with singleton { ReportsDataSourceImpl(instance()) }
        bind<WhoatRepository>() with singleton { WhoatRepositoryImpl(instance()) }
        bind() from provider { ReportsViewModelFactory(instance()) }
    }
}