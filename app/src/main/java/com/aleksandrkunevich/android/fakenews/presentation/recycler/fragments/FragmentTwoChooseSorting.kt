package com.aleksandrkunevich.android.fakenews.presentation.recycler.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aleksandrkunevich.android.fakenews.R

class FragmentTwoChooseSorting : Fragment() {

    companion object {
        const val TAG = "One"

        fun newInstance() = FragmentTwoChooseSorting()

        const val KEY = "Choose Sorting Fragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_two_radio, container, false)
}