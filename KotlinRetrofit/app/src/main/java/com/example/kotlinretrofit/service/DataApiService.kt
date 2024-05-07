package com.example.kotlinretrofit.service

import com.example.kotlinretrofit.model.DataModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataApiService {

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(DataApi::class.java)

    fun getDataApi(): Call<DataModel> {
        return retrofit.getData()
    }
}