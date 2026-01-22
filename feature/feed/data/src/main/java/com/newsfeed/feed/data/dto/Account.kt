package com.newsfeed.feed.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val id: String,
    val username: String,
    @SerialName("display_name") val displayName: String,
    val avatar: String
)