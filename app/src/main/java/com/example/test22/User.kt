package com.example.test22

data class User(
    val id: Int,
    val username: String,
    val email: String,
    val savedPlaces: MutableList<Place> = mutableListOf()
)