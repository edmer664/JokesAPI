package com.edmer.jokesapi.network

data class JokeData(
    val category: String,
    val error: Boolean,
    val flags: Flags,
    val id: Int,
    val lang: String,
    val safe: Boolean,
    val joke: String,
    val type: String
)