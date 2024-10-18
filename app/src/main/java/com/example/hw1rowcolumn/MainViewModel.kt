package com.example.hw1rowcolumn

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var itemArray = ArrayList<Int>()
    fun addItem(item: Int) {
        itemArray.add(item)
    }
}