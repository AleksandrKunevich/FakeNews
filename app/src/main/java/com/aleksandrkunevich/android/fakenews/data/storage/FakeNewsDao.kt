package com.aleksandrkunevich.android.fakenews.data.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FakeNewsDao {

    @Query("SELECT * FROM fakeNews")
    fun getAll(): List<FakeNewsEntity>

    @Insert
    fun insetFakeNews(fakeNews: FakeNewsEntity)

    @Delete
    fun deleteFakeNews(fakeNews: FakeNewsEntity)
}