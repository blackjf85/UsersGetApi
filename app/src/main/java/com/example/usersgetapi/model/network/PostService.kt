package com.example.usersgetapi.model.network

import com.example.usersgetapi.model.network.models.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

}