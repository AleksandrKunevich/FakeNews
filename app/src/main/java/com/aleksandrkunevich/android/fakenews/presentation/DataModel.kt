package com.aleksandrkunevich.android.fakenews.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel: ViewModel() {

    val sortingAlgorithm: MutableLiveData<Int> by lazy {MutableLiveData<Int>()}
}