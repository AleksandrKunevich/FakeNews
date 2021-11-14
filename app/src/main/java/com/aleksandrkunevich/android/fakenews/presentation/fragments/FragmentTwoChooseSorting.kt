package com.aleksandrkunevich.android.fakenews.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import com.aleksandrkunevich.android.fakenews.R
import com.aleksandrkunevich.android.fakenews.presentation.DataIdSortingViewModel

class FragmentTwoChooseSorting : Fragment() {

    companion object {
        const val TAG = "One"

        fun newInstance() = FragmentTwoChooseSorting()
    }

    private val dataModel: DataIdSortingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_two_radio, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val radio: RadioGroup = view.findViewById(R.id.radioGroup)
        radio.setOnCheckedChangeListener { group, checkedId ->
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