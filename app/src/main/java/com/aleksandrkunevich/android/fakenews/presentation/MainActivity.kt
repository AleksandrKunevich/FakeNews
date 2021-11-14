package com.aleksandrkunevich.android.fakenews.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aleksandrkunevich.android.fakenews.R
import com.aleksandrkunevich.android.fakenews.presentation.fragments.FragmentOneFakeNews

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initFakeNews()
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