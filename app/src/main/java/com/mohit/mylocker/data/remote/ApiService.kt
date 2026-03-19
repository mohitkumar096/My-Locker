package com.mohit.mylocker.data.remote

import com.mohit.mylocker.domain.model.User
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}