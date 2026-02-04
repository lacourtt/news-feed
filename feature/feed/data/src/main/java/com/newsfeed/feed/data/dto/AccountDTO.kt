package com.newsfeed.feed.data.dto

import com.newsfeed.feed.domain.domainobjects.Account
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountDTO(
    val id: String,
    val username: String,
    @SerialName("display_name") val displayName: String,
    val avatar: String
)

fun AccountDTO.toDomainObject(): Account {
    return Account(
        id = id,
        username = username,
        displayName = displayName,
        avatar = avatar
    )
}
