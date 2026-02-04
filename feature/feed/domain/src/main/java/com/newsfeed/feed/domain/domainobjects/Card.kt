package com.newsfeed.feed.domain.domainobjects

import kotlinx.serialization.Serializable

@Serializable
data class Card(
    val title: String,
    val description: String,
    val url: String,
    val image: String?
)