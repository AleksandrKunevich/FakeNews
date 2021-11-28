package com.aleksandrkunevich.android.fakenews.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        FakeNewsEntity::class
    ],
    version = AppDatabase.VERSION
)

abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val VERSION = 1
    }

    abstract fun getFakeNewsDao(): FakeNewsDao
}
