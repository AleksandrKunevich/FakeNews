package com.aleksandrkunevich.android.fakenews.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.aleksandrkunevich.android.fakenews.data.storage.FakeNewsDao
import com.aleksandrkunevich.android.fakenews.domain.FakeNews
import com.aleksandrkunevich.android.fakenews.domain.FakeNewsInteractor

class FakeNewsInteractorImplementation(private val fakeNewsDao: FakeNewsDao) : FakeNewsInteractor {
    override suspend fun getFakeNews(): List<FakeNews> {
        return withContext(Dispatchers.IO) {
            fakeNewsDao.getAll().map { fakeNewsEntity -> fakeNewsEntity.toFakeNews() }
        }
    }

    override suspend fun insertFakeNews(vararg fakeNews: FakeNews) {
        withContext(Dispatchers.IO) {
            fakeNews
                .map { domainFakeNews -> domainFakeNews.toFakeNewsEntity() }
                .forEach { fakeNewsEntity -> fakeNewsDao.insetFakeNews(fakeNewsEntity) }
        }
    }
}
