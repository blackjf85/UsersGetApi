package com.example.usersgetapi.model.repository

import com.example.usersgetapi.model.network.ApiManager
import com.example.usersgetapi.model.network.models.Post

class PostRepository(
    private val apiManager: ApiManager
) {
    suspend fun getPosts(): List<Post>? {
        return try {
            val response = apiManager.getPosts()
            if (response.isSuccessful) {
                response.body()
            } else {
                emptyList()
            }
        } catch (ex: Exception) {
            emptyList()
        }
    }
}