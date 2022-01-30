package com.example.usersgetapi.model.repository

import com.example.usersgetapi.model.network.ApiManager
import com.example.usersgetapi.model.network.models.User

class UserRepository(
    private val apiManager: ApiManager
) {
    suspend fun getUsers(): List<User>? {
        return try {
            val response = apiManager.getUsers()
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