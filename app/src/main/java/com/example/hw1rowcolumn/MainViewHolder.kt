package com.example.hw1rowcolumn

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw1rowcolumn.databinding.ActivityMainBinding

class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val text = view.findViewById<TextView>(R.id.text_view_1)
    val image = view.findViewById<ImageView>(R.id.image_view)

    fun bind(number: Int) {
        text.text = "$number"
        if (number % 2 == 0) {
            image.setBackgroundResource(R.color.blue)
        }
        else {
            image.setBackgroundResource(R.color.red)
        }
    }
}