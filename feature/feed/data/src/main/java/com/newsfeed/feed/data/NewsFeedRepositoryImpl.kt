package com.newsfeed.feed.data

import androidx.paging.Pager
import androidx.paging.PagingData
import com.newsfeed.feed.data.di.PagingModule.NewsPager
import com.newsfeed.feed.domain.NewsFeedRepository
import com.newsfeed.feed.domain.domainobjects.NewsItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsFeedRepositoryImpl @Inject constructor(
    @NewsPager private val newsPager: Pager<String, NewsItem>
) : NewsFeedRepository {
    override fun getNewsFeed(): Flow<PagingData<NewsItem>> {
        return newsPager.flow
    }
}