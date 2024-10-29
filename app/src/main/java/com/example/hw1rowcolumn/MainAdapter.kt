package com.example.hw1rowcolumn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.DiffResult
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(val listener: Listener) : RecyclerView.Adapter<MainViewHolder>() {

    private val items = ArrayList<Int>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }


    fun setItems(newList: List<Int>) {
        val diffCallback = MainDiffCallback(items, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items.clear()
        items.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
    interface Listener {
        fun onClick(position: Int)
    }

}