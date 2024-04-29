package com.example.kotlinsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create Database
        val db = this.openOrCreateDatabase("Users", MODE_PRIVATE, null)
        db.execSQL("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name VARCHAR, age INTEGER)")

        // Insert Data
//         db.execSQL("INSERT INTO users (name, age) VALUES ('Icardi', 30)")
//         db.execSQL("INSERT INTO users (name, age) VALUES ('Burak', 37)")
//         db.execSQL("INSERT INTO users (name, age) VALUES ('Ali', 30)")
//         db.execSQL("INSERT INTO users (name, age) VALUES ('Mehmet', 35)")
//         db.execSQL("INSERT INTO users (name, age) VALUES ('Hasan', 40)")

        // Read Database
        val cursor = db.rawQuery("SELECT * FROM users", null)
        val idIndex = cursor.getColumnIndex("id")
        val nameIndex = cursor.getColumnIndex("name")
        val ageIndex = cursor.getColumnIndex("age")

        // Row Count
//         println("Row Count: ${cursor.count}")

        // Read Data
         cursor.moveToFirst()
         while (!cursor.isAfterLast) {
             println("ID: ${cursor.getInt(idIndex)}")
             println("Name: ${cursor.getString(nameIndex)}")
             println("Age: ${cursor.getInt(ageIndex)}")
             cursor.moveToNext()
         }


        // Read Database using Query
//        val cursor = db.rawQuery("SELECT * FROM users WHERE name = 'Burak'", null)
//        val idIndex = cursor.getColumnIndex("id")
//        val nameIndex = cursor.getColumnIndex("name")
//        val ageIndex = cursor.getColumnIndex("age")
//        cursor.moveToFirst()
//
//        while (!cursor.isAfterLast) {
//            println("ID: ${cursor.getInt(idIndex)}")
//            println("Name: ${cursor.getString(nameIndex)}")
//            println("Age: ${cursor.getInt(ageIndex)}")
//            cursor.moveToNext()
//        }

//        val cursor = db.rawQuery("SELECT * FROM users WHERE name LIKE 'B%'", null)
//        val idIndex = cursor.getColumnIndex("id")
//        val nameIndex = cursor.getColumnIndex("name")
//        val ageIndex = cursor.getColumnIndex("age")
//        cursor.moveToFirst()
//
//        while (!cursor.isAfterLast) {
//            println("ID: ${cursor.getInt(idIndex)}")
//            println("Name: ${cursor.getString(nameIndex)}")
//            println("Age: ${cursor.getInt(ageIndex)}")
//            cursor.moveToNext()
//        }

        // Update Data
//        db.execSQL("UPDATE users SET age = 25 WHERE name = 'Icardi'")
//        db.execSQL("UPDATE users SET name = 'Burak' WHERE name = 'Ali'")

        // Delete Data
//        db.execSQL("DELETE FROM users WHERE name = 'Hasan'")

    }
}