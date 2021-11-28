package com.aleksandrkunevich.android.fakenews.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import com.aleksandrkunevich.android.fakenews.R
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

    private val adapter by lazy { FakeNewsAdapter() }
    private val dataModelIdSorting: DataIdSortingViewModel by activityViewModels()
    private val fakeNewsViewModel by viewModel<FakeNewsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_one_news, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewFakeNews.adapter = adapter

        getOrInsertAndGetFakeNewsFromDataBase()
        val button: Button = view.findViewById(R.id.buttonSorting)
        button.setOnClickListener {
            openChooseSortingFragment()
        }
        dataModelIdSorting.getIdSortingAlgorithm()
            .observe(viewLifecycleOwner) { idSortingAlgorithm ->
                adapter.reloadSortedRecycler(idSortingAlgorithm)
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

//    private fun initRecycler(newfakeNews: List<FakeNews>) {
//        recyclerViewFakeNews.apply {
//            layoutManager = LinearLayoutManager(activity)
//            adapter.submitList(newfakeNews)
//        }
//    }

    private fun getOrInsertAndGetFakeNewsFromDataBase() {
        fakeNewsViewModel.loadFakeNews()
        fakeNewsViewModel.fakeNews.observe(viewLifecycleOwner) { newFakeNews ->
            if (newFakeNews.isEmpty()) {
                fakeNewsViewModel.insertFakeNews()
                fakeNewsViewModel.loadFakeNews()
                adapter.submitList(newFakeNews)
            } else {
                adapter.submitList(newFakeNews)
            }
        }
    }
}

