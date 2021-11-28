package com.aleksandrkunevich.android.fakenews.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.aleksandrkunevich.android.fakenews.R
import com.aleksandrkunevich.android.fakenews.domain.FakeNews
import com.aleksandrkunevich.android.fakenews.presentation.DataIdSortingViewModel
import com.aleksandrkunevich.android.fakenews.presentation.FakeNewsViewModel
import com.aleksandrkunevich.android.fakenews.presentation.recycler.FakeNewsAdapter
import kotlinx.android.synthetic.main.fragment_one_news.*
import org.koin.android.viewmodel.ext.android.viewModel

class FragmentOneFakeNews : Fragment() {

    companion object {
        const val TAG = "One"

        fun newInstance() = FragmentOneFakeNews()
    }

    private val adapterFakeNews by lazy { FakeNewsAdapter() }
    private val dataModelIdSorting: DataIdSortingViewModel by activityViewModels()
    private val fakeNewsViewModel by viewModel<FakeNewsViewModel>()
    private var items: List<FakeNews> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_one_news, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewFakeNews.adapter = adapterFakeNews

        getOrInsertAndGetFakeNewsFromDataBase()
        val button: Button = view.findViewById(R.id.buttonSorting)
        button.setOnClickListener {
            openChooseSortingFragment()
        }
        dataModelIdSorting.getIdSortingAlgorithm()
            .observe(viewLifecycleOwner) { idSortingAlgorithm ->
                reloadSortedRecycler(idSortingAlgorithm)
            }
    }

    private fun openChooseSortingFragment() {
        val trans: FragmentTransaction = parentFragmentManager.beginTransaction()
        trans.add(
            R.id.frameLayout,
            FragmentTwoChooseSorting.newInstance(),
            FragmentTwoChooseSorting.TAG
        )
        trans.commit()
    }

    private fun getOrInsertAndGetFakeNewsFromDataBase() {
        fakeNewsViewModel.loadFakeNews()
        fakeNewsViewModel.fakeNews.observe(this) { newFakeNews ->
            recyclerViewFakeNews.layoutManager = LinearLayoutManager(activity)
            if (newFakeNews.isEmpty()) {
                fakeNewsViewModel.insertFakeNews()
                fakeNewsViewModel.loadFakeNews()
                items = newFakeNews
                adapterFakeNews.submitList(newFakeNews)
            } else {
                items = newFakeNews
                adapterFakeNews.submitList(newFakeNews)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun reloadSortedRecycler(sortedId: Int) {
        recyclerViewFakeNews.layoutManager = LinearLayoutManager(activity)
        when (sortedId) {
            R.id.radioButtonAuthor -> {
                adapterFakeNews.submitList(items.sortedBy {
                    it.author
                })
            }

            R.id.radioButtonDate -> {
                adapterFakeNews.submitList(items.sortedBy {
                    it.date
                })
            }

            R.id.radioButtonTitle -> {
                adapterFakeNews.submitList(items.sortedBy {
                    it.title
                })
            }
        }
    }
}
