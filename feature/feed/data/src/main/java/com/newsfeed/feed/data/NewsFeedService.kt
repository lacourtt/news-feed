package com.newsfeed.feed.data

import com.newsfeed.feed.data.dto.NewsItem
import retrofit2.Response
import retrofit2.http.GET

interface NewsFeedService {
    @GET("/api/v1/timelines/tag/news?language=en-US")
    suspend fun getNewsList(): Response<List<NewsItem>>
}