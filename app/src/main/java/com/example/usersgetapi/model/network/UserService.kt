package com.example.usersgetapi.model.network

import com.example.usersgetapi.model.network.models.User
import retrofit2.Response
import retrofit2.http.GET

interface UserService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

}