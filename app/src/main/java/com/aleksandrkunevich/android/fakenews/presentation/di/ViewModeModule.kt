package com.aleksandrkunevich.android.fakenews.presentation.di

import com.aleksandrkunevich.android.fakenews.presentation.FakeNewsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        FakeNewsViewModel(
            fakeNewsInteractor = get())
    }
}