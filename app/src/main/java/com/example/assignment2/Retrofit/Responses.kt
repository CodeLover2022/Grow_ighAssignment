package com.example.assignment2.Retrofit

data class Responses(
    val hits: ArrayList<Hit>,
    val total: Int,
    val totalHits: Int
)