package com.example.myimmo

import kotlinx.serialization.Serializable

@Serializable
data class Property(
    val id: Int,
    val name: String,
    val price: Double
)
