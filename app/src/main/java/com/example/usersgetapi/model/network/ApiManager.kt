package com.example.usersgetapi.model.network

class ApiManager {

    private var userService: UserService =
        RetrofitInstance.providesRetrofit().create(UserService::class.java)

    private var postService: PostService =
        RetrofitInstance.providesRetrofit().create(PostService::class.java)

        suspend fun getUsers() = userService.getUsers()

        suspend fun getPosts() = postService.getPosts()

    }