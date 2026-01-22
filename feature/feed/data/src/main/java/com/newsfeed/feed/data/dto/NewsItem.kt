package com.newsfeed.feed.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsItem(
    val id: String,
    @SerialName("created_at") val createdAt: String,
    val content: String, // Note: This contains HTML tags
    val account: Account,
    @SerialName("media_attachments") val mediaAttachments: List<MediaAttachment>,
    val card: Card? // Nullable: Not all posts have a news link/preview
)