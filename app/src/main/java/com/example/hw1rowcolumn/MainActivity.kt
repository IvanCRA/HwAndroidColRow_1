package com.example.hw1rowcolumn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.hw1rowcolumn.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        adapter = MainAdapter()

        binding.recyclerView.adapter = adapter

        lifecycleScope.launchWhenStarted {
            viewModel.itemArray.collect { items ->
                adapter.setItems(items)
            }
        }

        binding.fab.setOnClickListener {
            val newItem = adapter.itemCount + 1
            viewModel.addItem(newItem)
        }



    }

}
