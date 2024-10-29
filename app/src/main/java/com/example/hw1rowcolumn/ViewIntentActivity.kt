package com.example.hw1rowcolumn

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ViewIntentActivity : AppCompatActivity() {
    private lateinit var lin_lay: LinearLayout
    private lateinit var text_intent: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_intent)

        lin_lay = findViewById<LinearLayout>(R.id.lin_layout)
        text_intent = findViewById<TextView>(R.id.text_intent)

        var position: Int = 0

        if (intent.hasExtra(MainActivity.NEXT_SCREEN)) {
            position = intent.getIntExtra(MainActivity.NEXT_SCREEN, 0)
        }

        lin_lay.setBackgroundResource(R.color.blue)
        text_intent.text = "${position}"
        if (position % 2 == 0) {
            lin_lay.setBackgroundResource(R.color.blue)
        } else {
            lin_lay.setBackgroundResource(R.color.red)
        }
    }
}