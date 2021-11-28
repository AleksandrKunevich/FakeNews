package com.aleksandrkunevich.android.fakenews.presentation.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import com.aleksandrkunevich.android.fakenews.presentation.FakeNewsViewModel

val viewModelModule = module {
    viewModel {
        FakeNewsViewModel(
//            fakeNewsInteractor = get())
            get())
    }
}