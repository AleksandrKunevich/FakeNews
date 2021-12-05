package com.aleksandrkunevich.android.fakenews.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.map
import androidx.recyclerview.widget.LinearLayoutManager
import com.aleksandrkunevich.android.fakenews.databinding.FragmentTwoRadioBinding
import com.aleksandrkunevich.android.fakenews.domain.FakeNews
import com.aleksandrkunevich.android.fakenews.presentation.DataIdSortingViewModel
import com.aleksandrkunevich.android.fakenews.presentation.FakeNewsViewModel
import com.aleksandrkunevich.android.fakenews.presentation.recycler.FakeNewsAdapter
import kotlinx.android.synthetic.main.fragment_one_news.*
import org.koin.android.viewmodel.ext.android.viewModel

class FragmentTwoChooseSorting : Fragment() {

    private val dataModelIdSorting: DataIdSortingViewModel by activityViewModels()
    private val dataModel: DataIdSortingViewModel by activityViewModels()
    private lateinit var binding: FragmentTwoRadioBinding
    private lateinit var binding2: FragmentTwoRadioBinding
    private val adapterFakeNews by lazy { FakeNewsAdapter() }
    private val fakeNewsViewModel by viewModel<FakeNewsViewModel>()

    companion object {
        const val TAG = "One"

        fun newInstance() = FragmentTwoChooseSorting()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTwoRadioBinding.inflate(inflater, container, false)
        binding2 = FragmentTwoRadioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            getIdChooseSortingAlgorithm(checkedId)
            closeChooseFragment()
        }

        dataModelIdSorting.selected.observe(viewLifecycleOwner) { idSorting ->
            val items: List<FakeNews>? = fakeNewsViewModel.fakeNews.value
            items?.let { reloadSortedRecycler(it, idSorting) }
        }
    }

    private fun closeChooseFragment() {
        val trans: FragmentTransaction = parentFragmentManager.beginTransaction()
        trans.remove(this)
        trans.commit()
    }

    private fun getIdChooseSortingAlgorithm(id: Int) {
        dataModel.setIdSortingAlgorithm(id)
    }

    private fun reloadSortedRecycler(items: List<FakeNews>, sortedId: Int) {
        recyclerViewFakeNews.layoutManager = LinearLayoutManager(activity)
        items.let {
            binding2.apply {
                when (sortedId) {
                    radioButtonAuthor.id -> {
                        adapterFakeNews.submitList(items.sortedBy {
                            it.author
                        })
                    }

                    radioButtonDate.id -> {
                        adapterFakeNews.submitList(items.sortedBy {
                            it.date
                        })
                    }

                    radioButtonTitle.id -> {
                        adapterFakeNews.submitList(items.sortedBy {
                            it.title
                        })
                    }
                }
            }
        }
    }
}