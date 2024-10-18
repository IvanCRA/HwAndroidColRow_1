package com.example.hw1rowcolumn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hw1rowcolumn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val adapter = MainAdapter()

        binding.recyclerView.adapter = adapter

        adapter.setItems(viewModel.itemArray)

        binding.fab.setOnClickListener {
            val newItem = adapter.itemCount + 1
            viewModel.addItem(newItem)
            adapter.setItems(viewModel.itemArray)
        }



    }

}
