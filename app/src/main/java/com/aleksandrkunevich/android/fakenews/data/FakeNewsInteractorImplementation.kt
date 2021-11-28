package com.aleksandrkunevich.android.fakenews.data

import com.aleksandrkunevich.android.fakenews.data.storage.FakeNewsDao
import com.aleksandrkunevich.android.fakenews.data.di.toFakeNews
import com.aleksandrkunevich.android.fakenews.data.di.toFakeNewsEntity
import com.aleksandrkunevich.android.fakenews.domain.FakeNews
import com.aleksandrkunevich.android.fakenews.domain.FakeNewsInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FakeNewsInteractorImplementation(private val fakeNewsDao: FakeNewsDao) : FakeNewsInteractor {

    override suspend fun getFakeNews(): List<FakeNews> {
        return withContext(Dispatchers.IO) {
            fakeNewsDao.getAllFakeNews().map { fakeNewsEntity ->
                fakeNewsEntity.toFakeNews()
            }
        }
    }

    override suspend fun insertFakeNews(vararg fakeNews: FakeNews) {
        withContext(Dispatchers.IO) {
            fakeNews
                .map { domainFakeNews -> domainFakeNews.toFakeNewsEntity() }
                .forEach { fakeNewsEntity -> fakeNewsDao.insetFakeNews(fakeNewsEntity) }
        }
    }

    override suspend fun deleteFakeNews(vararg fakeNews: FakeNews) {
        withContext(Dispatchers.IO) {
            fakeNews
                .map { domainFakeNews -> domainFakeNews.toFakeNewsEntity() }
                .forEach { fakeNewsEntity -> fakeNewsDao.deleteFakeNews(fakeNewsEntity) }
        }
    }
}
