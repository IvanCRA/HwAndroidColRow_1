package com.example.hw1rowcolumn

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private var _itemArray = MutableStateFlow<ArrayList<Int>>(ArrayList())
    val itemArray: StateFlow<ArrayList<Int>> = _itemArray
    fun addItem(item: Int) {
        _itemArray.update { currentArray ->
            val updateList = ArrayList(currentArray)
            updateList.add(item)
            updateList
        }

    }
}