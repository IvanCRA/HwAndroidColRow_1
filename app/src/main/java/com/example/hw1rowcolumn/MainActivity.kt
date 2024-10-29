package com.example.hw1rowcolumn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.hw1rowcolumn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainAdapter.Listener {

    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        adapter = MainAdapter(this)

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

    override fun onClick(position: Int) {
       val intent = Intent(this@MainActivity, ViewIntentActivity::class.java)
        intent.putExtra(NEXT_SCREEN, position)
        startActivity(intent)
    }
    companion object{
        val NEXT_SCREEN="details_screen"
    }

}
