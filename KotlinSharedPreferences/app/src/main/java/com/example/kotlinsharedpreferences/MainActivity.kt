package com.example.kotlinsharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var sharedPref : SharedPreferences
    lateinit var editText : EditText
    lateinit var textView : TextView
    lateinit var username : String
    lateinit var savedUsername : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // When the activity is created, we initialize the shared preferences
        sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)

        // We get the username from Shared Preferences
        savedUsername = sharedPref.getString("username", "").toString()

        // We set the text of the TextView to the saved username
        textView = findViewById<TextView>(R.id.textView)
        textView.text = "Saved username: $savedUsername"
    }

    fun handleSave(view: View) {
        // We get the username from the EditText
        editText = findViewById<EditText>(R.id.editText)
        username = editText.text.toString()

        if(username.isEmpty()){
            // If the username is empty, we show a toast
            Toast.makeText(this, "Please enter a username", Toast.LENGTH_SHORT).show()
        } else {
            // If the username is not empty, we save it in Shared Preferences
            sharedPref.edit().putString("username", username).apply()
            Toast.makeText(this, "Username saved", Toast.LENGTH_SHORT).show()

            // We get the username from Shared Preferences and set the text of the TextView
            savedUsername = sharedPref.getString("username", "").toString()
            textView.text = "Saved username: $savedUsername"
        }
    }

    fun handleDelete(view: View) {
        // We remove the username from Shared Preferences
        sharedPref.edit().remove("username").apply()
        Toast.makeText(this, "Username deleted", Toast.LENGTH_SHORT).show()

        // We get the username from Shared Preferences and set the text of the TextView
        savedUsername = sharedPref.getString("username", "").toString()
        textView.text = "Saved username: $savedUsername"
    }

}
