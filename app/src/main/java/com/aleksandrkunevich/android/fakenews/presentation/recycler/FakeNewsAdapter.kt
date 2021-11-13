package com.aleksandrkunevich.android.fakenews.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aleksandrkunevich.android.fakenews.data.FakeNewsDataSource

class FakeNewsAdapter : RecyclerView.Adapter<FakeNewsHolder>() {

    private val itemsFakeNews: List<FakeNews> = FakeNewsDataSource().loadNews()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FakeNewsHolder {
        val viewHolde = FakeNewsHolder.from(parent)
        return viewHolde
    }

    override fun onBindViewHolder(holder: FakeNewsHolder, position: Int) {
        holder.bindView(itemsFakeNews[position])
    }

    override fun getItemCount(): Int {
        return itemsFakeNews.size
    }
}