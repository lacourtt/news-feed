package com.newsfeed.feed.domain

import androidx.paging.PagingData
import com.newsfeed.feed.domain.domainobjects.NewsItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsFeedUseCaseImpl @Inject constructor(
    private val newsFeedRepository: NewsFeedRepository
) : GetNewsFeedUseCase {
    override operator fun invoke(): Flow<PagingData<NewsItem>> {
        return newsFeedRepository.getNewsFeed()
    }
}