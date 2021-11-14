package com.aleksandrkunevich.android.fakenews.presentation.recycler.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import com.aleksandrkunevich.android.fakenews.R
import com.aleksandrkunevich.android.fakenews.presentation.DataModel

class FragmentTwoChooseSorting : Fragment() {

    companion object {
        const val TAG = "One"

        fun newInstance() = FragmentTwoChooseSorting()
    }

    private val dataModel:DataModel by viewModels()

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
        dataModel.sortingAlgorithm.value = id
        Log.d("AAAA", "put $id")
    }
}