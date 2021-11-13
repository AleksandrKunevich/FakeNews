package com.aleksandrkunevich.android.fakenews.domain

import com.aleksandrkunevich.android.fakenews.presentation.recycler.FakeNews

interface FakeNewsInteractor {

    fun loadNews() : List<FakeNews>

}