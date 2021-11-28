package com.aleksandrkunevich.android.fakenews.domain

interface FakeNewsInteractor {

    suspend fun getFakeNews() : List<FakeNews>

    suspend fun insertFakeNews(vararg fakeNews: FakeNews)

    suspend fun deleteFakeNews(vararg fakeNews: FakeNews)
}