package com.aleksandrkunevich.android.fakenews

import android.app.Application
import com.aleksandrkunevich.android.fakenews.data.di.databaseModule
import com.aleksandrkunevich.android.fakenews.domain.di.domainModule
import com.aleksandrkunevich.android.fakenews.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FakeNewsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@FakeNewsApplication)
            modules(
                databaseModule,
                domainModule,
                viewModelModule,
            )
        }
    }
}