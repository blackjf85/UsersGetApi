package com.example.usersgetapi.model.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Address(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
)