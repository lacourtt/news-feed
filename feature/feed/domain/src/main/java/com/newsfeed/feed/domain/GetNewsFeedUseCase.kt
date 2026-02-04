    package com.newsfeed.feed.domain

    import androidx.paging.PagingData
    import com.newsfeed.feed.domain.domainobjects.NewsItem
    import kotlinx.coroutines.flow.Flow

    interface GetNewsFeedUseCase {
        operator fun invoke(): Flow<PagingData<NewsItem>>
    }