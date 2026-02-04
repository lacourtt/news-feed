package com.newsfeed.feed.domain

import androidx.paging.PagingData
import com.newsfeed.feed.domain.domainobjects.NewsItem
import kotlinx.coroutines.flow.Flow


interface NewsFeedRepository {
    fun getNewsFeed(): Flow<PagingData<NewsItem>>
}