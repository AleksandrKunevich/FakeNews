package com.aleksandrkunevich.android.fakenews.data.di

import androidx.room.Room
import com.aleksandrkunevich.android.fakenews.data.storage.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "fakeNews"
        ).build()
    }

    single {
        get<AppDatabase>().getFakeNewsDao()
    }
}
