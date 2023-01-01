package com.nmssalman.sampleroomdb.api

import com.nmssalman.sampleroomdb.dataclasses.todo.Todo
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitToDoAPI {

    @GET("/todos")
    suspend fun getTodos(): Response<List<Todo>>

}