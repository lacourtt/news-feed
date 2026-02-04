package com.newsfeed.feed.data.dto

import com.newsfeed.feed.domain.domainobjects.Card
import kotlinx.serialization.Serializable

@Serializable
data class CardDTO(
    val title: String,
    val description: String,
    val url: String,
    val image: String?
)

fun CardDTO.toDomainObject(): Card {
    return Card(
        title = title,
        description = description,
        url = url,
        image = image
    )
}