package com.example.kotlinretrofit.service

import com.example.kotlinretrofit.model.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface DataApi {
    @GET("todos/1")
    fun getData(): Call<DataModel>
}