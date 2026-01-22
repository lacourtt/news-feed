package com.newsfeed.feed.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Card(
    val title: String,
    val description: String,
    val url: String,
    val image: String?
)