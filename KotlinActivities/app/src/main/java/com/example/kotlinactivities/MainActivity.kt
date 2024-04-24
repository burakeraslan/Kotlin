package com.example.kotlinactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun handleSecondActivity(view: View) {
        val userValue = findViewById<EditText>(R.id.editText).text.toString()

        val intent = Intent(applicationContext, MainActivity2::class.java)
        intent.putExtra("userValue", userValue)
        startActivity(intent)
    }
}