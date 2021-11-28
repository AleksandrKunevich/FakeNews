package com.aleksandrkunevich.android.fakenews.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        FakeNewsEntity::class
    ],
    version = AppData.VERSION
)

abstract class AppData : RoomDatabase() {
    companion object {
        const val VERSION = 1
    }

    abstract fun getFakeNews() : FakeNewsDao
}
