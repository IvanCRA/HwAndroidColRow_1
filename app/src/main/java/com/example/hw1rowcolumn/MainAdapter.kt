package com.example.hw1rowcolumn

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainAdapter() : RecyclerView.Adapter<MainViewHolder>() {

    private val items = ArrayList<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(list: List<Int>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

}