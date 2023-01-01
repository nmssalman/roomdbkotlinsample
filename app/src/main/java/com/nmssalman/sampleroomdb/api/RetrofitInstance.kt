package com.nmssalman.sampleroomdb.api

import com.nmssalman.sampleroomdb.dataclasses.todo.Todo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: RetrofitToDoAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitToDoAPI::class.java)

    }
}