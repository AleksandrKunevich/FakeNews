package com.aleksandrkunevich.android.fakenews.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.aleksandrkunevich.android.fakenews.databinding.ActivityMainBinding
import com.aleksandrkunevich.android.fakenews.databinding.FragmentOneNewsBinding
import com.aleksandrkunevich.android.fakenews.databinding.FragmentTwoRadioBinding
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

    private lateinit var binding: FragmentOneNewsBinding
    private lateinit var binding2: FragmentTwoRadioBinding
    private lateinit var bindingActivity: ActivityMainBinding
    private val adapterFakeNews by lazy { FakeNewsAdapter() }
    private val fakeNewsViewModel by viewModel<FakeNewsViewModel>()
    private var items: List<FakeNews> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneNewsBinding.inflate(inflater, container, false)
        binding2 = FragmentTwoRadioBinding.inflate(inflater, container, false)
        bindingActivity = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewFakeNews.adapter = adapterFakeNews
        getOrInsertAndGetFakeNewsFromDataBase()

        binding.buttonSorting.setOnClickListener {
            openChooseSortingFragment()
        }
    }

    private fun openChooseSortingFragment() {
        val trans: FragmentTransaction = parentFragmentManager.beginTransaction()
        trans.add(
            bindingActivity.frameLayout.id,
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
}
