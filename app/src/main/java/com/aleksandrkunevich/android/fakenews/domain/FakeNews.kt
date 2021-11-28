package com.aleksandrkunevich.android.fakenews.domain

data class FakeNews(
    val title: String,
    val author: String,
    val date: String,
    val topic: String,
    val text: String
)