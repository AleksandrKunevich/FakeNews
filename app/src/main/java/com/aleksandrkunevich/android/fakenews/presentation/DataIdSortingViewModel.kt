package com.aleksandrkunevich.android.fakenews.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataIdSortingViewModel : ViewModel() {

    private val selected = MutableLiveData<Int>()

    fun setIdSortingAlgorithm(item: Int) {
        selected.value = item
    }

    fun getIdSortingAlgorithm(): LiveData<Int> {
        return selected
    }

}