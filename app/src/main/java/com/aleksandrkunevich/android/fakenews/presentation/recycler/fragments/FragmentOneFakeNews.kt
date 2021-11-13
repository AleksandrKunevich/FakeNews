package com.aleksandrkunevich.android.fakenews.presentation.recycler.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.aleksandrkunevich.android.fakenews.R
import com.aleksandrkunevich.android.fakenews.presentation.recycler.FakeNewsAdapter
import kotlinx.android.synthetic.main.fragment_one_news.*

class FragmentOneFakeNews : Fragment() {

    companion object {
        const val TAG = "One"

        fun newInstance() = FragmentOneFakeNews()

        const val KEY = "Fake News Fragment"
    }

    private val fakeNews by lazy { FakeNewsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_one_news, container, false)
        val button: Button = view.findViewById(R.id.buttonSorting)
        button.setOnClickListener {
            openChooseSortingFragment()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        recyclerViewFakeNews.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = fakeNews
        }
    }

    private fun openChooseSortingFragment() {
        val trans: FragmentTransaction = parentFragmentManager.beginTransaction()
        trans.replace(
            R.id.frameLayout,
            FragmentTwoChooseSorting.newInstance(),
            FragmentTwoChooseSorting.TAG
        )
        trans.commit()
    }
}