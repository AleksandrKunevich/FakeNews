package com.aleksandrkunevich.android.fakenews.domain

interface FakeNewsInteractor {
    suspend fun getFakeNews() : List<FakeNews>

    suspend fun insertFakeNews(vararg fakeNews: FakeNews)
}