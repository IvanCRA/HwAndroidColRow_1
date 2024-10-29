package com.example.hw1rowcolumn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw1rowcolumn.databinding.ActivityMainBinding

class MainViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)) {

    private val text = itemView.findViewById<TextView>(R.id.text_view_1)
    private val image = itemView.findViewById<ImageView>(R.id.image_view)

    fun bind(number: Int, listener: MainAdapter.Listener) {
        text.text = "$number"
        if (number % 2 == 0) {
            image.setBackgroundResource(R.color.blue)
        } else {
            image.setBackgroundResource(R.color.red)
        }
        itemView.setOnClickListener {
            listener.onClick(number)
        }
    }
}