package com.aleksandrkunevich.android.fakenews.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aleksandrkunevich.android.fakenews.databinding.ActivityMainBinding
import com.aleksandrkunevich.android.fakenews.presentation.fragments.FragmentOneFakeNews

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        initFakeNews()
    }

    private fun initFakeNews() {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(FragmentOneFakeNews.TAG)
            .replace(
                binding.frameLayout.id,
                FragmentOneFakeNews.newInstance(),
                FragmentOneFakeNews.TAG
            )
            .commit()
    }
}