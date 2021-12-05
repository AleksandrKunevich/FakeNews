package com.aleksandrkunevich.android.fakenews.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DataIdSortingViewModel() : ViewModel() {

    private val _selected = MutableLiveData<Int>()
    val selected: LiveData<Int> get() = _selected

    fun setIdSortingAlgorithm(item: Int) {
        viewModelScope.launch {
            _selected.value = item
        }
    }
}