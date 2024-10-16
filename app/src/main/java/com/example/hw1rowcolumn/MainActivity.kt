package com.example.hw1rowcolumn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.hw1rowcolumn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val adapter = MainAdapter()

    var itemArray = ArrayList<Int>()

    val ITEM_ARRAY_KEY = "itemArray"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.recyclerView.adapter = adapter

        binding.fab.setOnClickListener {
            adapter.addItems(adapter.itemCount + 1)
        }

        if (savedInstanceState !=  null) {
            itemArray = savedInstanceState.getIntegerArrayList(ITEM_ARRAY_KEY) as ArrayList<Int>
            adapter.setItems(itemArray)
        } else {
            adapter.setItems(itemArray)
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putIntegerArrayList(ITEM_ARRAY_KEY, adapter.getItems())
        super.onSaveInstanceState(savedInstanceState)
    }



}
