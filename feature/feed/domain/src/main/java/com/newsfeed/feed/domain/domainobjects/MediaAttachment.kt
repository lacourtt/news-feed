package com.newsfeed.feed.domain.domainobjects

import kotlinx.serialization.Serializable

@Serializable
data class MediaAttachment(
    val id: String,
    val type: String, // e.g., "image"
    val url: String
)