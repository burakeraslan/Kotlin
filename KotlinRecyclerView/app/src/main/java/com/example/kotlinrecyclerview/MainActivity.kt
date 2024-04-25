package com.example.kotlinrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create a list of data
        val data = ArrayList<String>()
        for (i in 0..20) {
            data.add("Item $i")
        }

        // Adapter
        val layoutManager = LinearLayoutManager(this)
        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        val adapter = RecyclerAdapter(data)
        recyclerView.adapter = adapter
    }
}