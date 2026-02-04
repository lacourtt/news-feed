package com.newsfeed.feed.data.dto

import com.newsfeed.feed.domain.domainobjects.MediaAttachment
import kotlinx.serialization.Serializable

@Serializable
data class MediaAttachmentDTO(
    val id: String,
    val type: String, // e.g., "image"
    val url: String
)

fun List<MediaAttachmentDTO>.toDomainObject(): List<MediaAttachment> {
    return map { dto ->
        MediaAttachment(
            id = dto.id,
            type = dto.type,
            url = dto.url
        )
    }
}