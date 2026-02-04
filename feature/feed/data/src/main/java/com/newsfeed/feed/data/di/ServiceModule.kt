package com.newsfeed.feed.data.di

import com.newsfeed.feed.data.NewsFeedService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideNewsFeedService(retrofit: Retrofit): NewsFeedService {
        return retrofit.create(NewsFeedService::class.java)
    }
}