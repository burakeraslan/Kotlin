package com.example.kotlinactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent = intent
        val userValue = intent.getStringExtra("userValue")

        findViewById<TextView>(R.id.textView2).text = userValue
    }
}