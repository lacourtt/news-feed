package com.newsfeed.feed.data.dto

import com.newsfeed.feed.domain.domainobjects.NewsItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsItemDTO(
    val id: String,
    @SerialName("created_at") val createdAt: String,
    val content: String, // Note: This contains HTML tags
    val account: AccountDTO,
    @SerialName("media_attachments") val mediaAttachments: List<MediaAttachmentDTO>,
    val card: CardDTO? = null // Nullable: Not all posts have a news link/preview
)

fun NewsItemDTO.toDomainObject(): NewsItem {
    return NewsItem(
        id = id,
        createdAt = createdAt,
        content = content,
        account = account.toDomainObject(),
        mediaAttachments = mediaAttachments.toDomainObject(),
        card = card?.toDomainObject()
    )
}