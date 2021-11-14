package com.aleksandrkunevich.android.fakenews.presentation.recycler

import android.annotation.SuppressLint
import android.os.Build
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aleksandrkunevich.android.fakenews.R
import com.aleksandrkunevich.android.fakenews.data.FakeNewsDataSource
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class FakeNewsAdapter : RecyclerView.Adapter<FakeNewsHolder>() {

    private val itemsFakeNews: List<FakeNews> = FakeNewsDataSource().loadNews()
    private val setSortedItems = itemsFakeNews as MutableList<FakeNews>

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
    fun reloadSortedRecycler(sortedId: Int) {
        when (sortedId) {
            R.id.radioButtonAuthor -> {
                setSortedItems.sortBy {
                    it.author
                }
            }
            R.id.radioButtonDate -> {
                setSortedItems.sortBy {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
                        val date = LocalDate.parse(it.date, formatter)
                        date.toString()
                    } else {
                        it.date
                    }
                }

            }
            R.id.radioButtonTitle -> {
                setSortedItems.sortBy {
                    it.title
                }
            }
        }
        notifyDataSetChanged()
    }
}