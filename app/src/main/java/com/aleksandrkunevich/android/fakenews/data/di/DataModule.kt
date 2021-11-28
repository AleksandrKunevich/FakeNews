package com.aleksandrkunevich.android.fakenews.data.di

import androidx.room.Room
import com.aleksandrkunevich.android.fakenews.data.storage.AppData
import org.koin.dsl.module

val dataModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppData::class.java,
            "fakenews"
        ).build()
    }

    single {
        get<AppData>().getFakeNews()
    }
}
