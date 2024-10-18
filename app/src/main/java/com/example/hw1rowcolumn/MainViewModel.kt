package com.example.hw1rowcolumn

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private var _itemArray = MutableStateFlow<ArrayList<Int>>(ArrayList())
    val itemArray: StateFlow<ArrayList<Int>> = _itemArray
    fun addItem(item: Int) {
        val updateList = ArrayList(_itemArray.value)
        updateList.add(item)
        _itemArray.value = updateList
    }
}