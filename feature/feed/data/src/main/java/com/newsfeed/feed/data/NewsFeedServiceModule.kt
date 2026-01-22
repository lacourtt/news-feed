package com.newsfeed.feed.data

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NewsFeedServiceModule {
    fun provideNewsFeedService(retrofit: Retrofit): NewsFeedService {
        return retrofit.create(NewsFeedService::class.java)
    }
}