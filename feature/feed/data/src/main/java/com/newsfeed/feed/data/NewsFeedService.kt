package com.newsfeed.feed.data

import com.newsfeed.feed.data.dto.NewsItemDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface NewsFeedService {

    @GET
    suspend fun getNews(@Url url: String): Response<List<NewsItemDTO>>

    @GET("/api/v1/timelines/tag/news?language=en-US&limit=40")
    suspend fun getNewerPosts(cursor: String, @Query("since_id") sinceId: String): Response<NewsItemDTO>

    @GET("/api/v1/timelines/tag/news?language=en-US&limit=40")
    suspend fun getOlderPosts(@Query("max_id") maxId: String): Response<NewsItemDTO>
}