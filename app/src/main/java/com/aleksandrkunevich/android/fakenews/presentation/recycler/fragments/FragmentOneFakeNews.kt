package com.aleksandrkunevich.android.fakenews.presentation.recycler.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.aleksandrkunevich.android.fakenews.R
import com.aleksandrkunevich.android.fakenews.presentation.DataModel
import com.aleksandrkunevich.android.fakenews.presentation.recycler.FakeNewsAdapter
import kotlinx.android.synthetic.main.fragment_one_news.*

class FragmentOneFakeNews : Fragment() {

    companion object {
        const val TAG = "One"

        fun newInstance() = FragmentOneFakeNews()
    }

    private val fakeNews by lazy { FakeNewsAdapter() }
    private val dataModel: DataModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_one_news, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        val button: Button = view.findViewById(R.id.buttonSorting)
        button.setOnClickListener {
            openChooseSortingFragment()
        }
        dataModel.sortingAlgorithm.observe(viewLifecycleOwner,{ idSortingAlgorithm ->
            Toast.makeText(context, "$idSortingAlgorithm", Toast.LENGTH_SHORT).show()
            Log.d("AAAA", "get $idSortingAlgorithm")
        })
    }

    private fun initRecycler() {
        recyclerViewFakeNews.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = fakeNews
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
}