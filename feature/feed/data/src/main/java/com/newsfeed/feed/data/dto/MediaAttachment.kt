package com.newsfeed.feed.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class MediaAttachment(
    val id: String,
    val type: String, // e.g., "image"
    val url: String
)