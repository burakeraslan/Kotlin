package com.example.kotlinrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SelectedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected)

        val data = intent.getStringExtra("data")
        findViewById<android.widget.TextView>(R.id.textView).text = "Selected: $data"
    }
}