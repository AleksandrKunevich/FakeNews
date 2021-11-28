package com.aleksandrkunevich.android.fakenews.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aleksandrkunevich.android.fakenews.R
import com.aleksandrkunevich.android.fakenews.domain.FakeNews
import kotlinx.android.synthetic.main.recyclerview_item_layout.view.*

class FakeNewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun from(parent: ViewGroup): FakeNewsHolder {
            return FakeNewsHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.recyclerview_item_layout, parent, false)
            )
        }
    }

    private val titleTV: TextView by lazy { itemView.title }
    private val authorTV: TextView by lazy { itemView.author }
    private val dateTV: TextView by lazy { itemView.date }


    fun bindView(item: FakeNews) {
        titleTV.text = item.title
        authorTV.text = item.author
        dateTV.text = item.date
    }
}