package com.example.usersgetapi.model.network

class ApiManager {

        private var userService: UserService =
            RetrofitInstance.providesRetrofit().create(UserService::class.java)

        suspend fun getUsers() = userService.getUsers()

    }