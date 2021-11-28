package com.aleksandrkunevich.android.fakenews.data.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FakeNewsDao {
    @Query("SELECT * FROM fakenews")
    fun getAllFakeNews(): List<FakeNewsEntity>

    @Insert
    fun insetFakeNews(fakenews: FakeNewsEntity)

    @Delete
    fun deleteFakeNews(fakenews: FakeNewsEntity)
}