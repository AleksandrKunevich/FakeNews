package com.aleksandrkunevich.android.fakenews.domain.di

import com.aleksandrkunevich.android.fakenews.data.FakeNewsInteractorImplementation
import com.aleksandrkunevich.android.fakenews.domain.FakeNewsInteractor
import org.koin.dsl.module

val domainModule = module {
    single<FakeNewsInteractor> {
        FakeNewsInteractorImplementation(fakeNewsDao = get())
    }
}
