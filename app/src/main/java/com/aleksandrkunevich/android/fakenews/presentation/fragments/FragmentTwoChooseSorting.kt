package com.aleksandrkunevich.android.fakenews.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import com.aleksandrkunevich.android.fakenews.databinding.FragmentTwoRadioBinding
import com.aleksandrkunevich.android.fakenews.presentation.DataIdSortingViewModel

class FragmentTwoChooseSorting : Fragment() {

    private val dataModel: DataIdSortingViewModel by activityViewModels()
    private lateinit var binding: FragmentTwoRadioBinding

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            getIdChooseSortingAlgorithm(checkedId)
            closeChooseFragment()
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
}