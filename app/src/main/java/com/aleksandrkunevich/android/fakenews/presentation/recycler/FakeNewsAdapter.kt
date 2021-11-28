package com.aleksandrkunevich.android.fakenews.presentation.recycler

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aleksandrkunevich.android.fakenews.R
import com.aleksandrkunevich.android.fakenews.domain.FakeNews
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class FakeNewsAdapter : RecyclerView.Adapter<FakeNewsHolder>() {

    private var itemsFakeNews: List<FakeNews> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FakeNewsHolder {
        return FakeNewsHolder.from(parent)
    }

    override fun onBindViewHolder(holder: FakeNewsHolder, position: Int) {
        holder.bindView(itemsFakeNews[position])
    }

    override fun getItemCount(): Int {
        return itemsFakeNews.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(data: List<FakeNews>) {
        itemsFakeNews = data
        notifyDataSetChanged()
    }
}