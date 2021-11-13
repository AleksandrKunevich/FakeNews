package com.aleksandrkunevich.android.fakenews.presentation

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.aleksandrkunevich.android.fakenews.R
import com.aleksandrkunevich.android.fakenews.presentation.recycler.fragments.FragmentOneFakeNews
import com.aleksandrkunevich.android.fakenews.presentation.recycler.fragments.FragmentTwoChooseSorting

class MainActivity : AppCompatActivity() {

//    private val buttonSorting: Button by lazy { findViewById(R.id.buttonSorting) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initFakeNews()

//        buttonSorting.setOnClickListener {
//            openChooseSortingFragment(
//                FragmentTwoChooseSorting.newInstance(),
//                FragmentTwoChooseSorting.TAG
//            )
//        }
    }

    private fun initFakeNews() {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(FragmentOneFakeNews.TAG)
            .add(
                R.id.frameLayout,
                FragmentOneFakeNews.newInstance(),
                FragmentOneFakeNews.TAG
            )
            .commit()
    }


}