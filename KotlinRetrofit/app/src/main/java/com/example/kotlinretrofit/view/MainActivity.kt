package com.example.kotlinretrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinretrofit.R
import com.example.kotlinretrofit.model.DataModel
import com.example.kotlinretrofit.service.DataApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataApiService = DataApiService()
        val data = dataApiService.getDataApi()

        data.enqueue(object: Callback<DataModel> {
            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                println("Error: ${t.message}")
            }

            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                if (response.isSuccessful) {
                    val dataModel = response.body()
                    println("User ID: ${dataModel?.userId}, " +
                            "ID: ${dataModel?.id}, " +
                            "Title: ${dataModel?.title}, " +
                            "Completed: ${dataModel?.completed}")
                }
            }
        })
    }
}