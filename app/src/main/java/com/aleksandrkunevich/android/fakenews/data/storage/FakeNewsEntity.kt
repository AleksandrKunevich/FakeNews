package com.aleksandrkunevich.android.fakenews.data.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fakeNews")
data class FakeNewsEntity(

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "author")
    val author: String,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "topic")
    val topic: String,

    @ColumnInfo(name = "text")
    val text: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
