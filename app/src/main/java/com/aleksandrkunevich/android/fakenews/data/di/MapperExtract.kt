package com.aleksandrkunevich.android.fakenews.data.di

import com.aleksandrkunevich.android.fakenews.data.storage.FakeNewsEntity
import com.aleksandrkunevich.android.fakenews.domain.FakeNews

fun FakeNewsEntity.toFakeNews() =
    FakeNews(
        title = title,
        author = author,
        date = date,
        topic = topic,
        text = text
    )

fun FakeNews.toFakeNewsEntity() =
    FakeNewsEntity(
        title = title,
        author = author,
        date = date,
        topic = topic,
        text = text
    )