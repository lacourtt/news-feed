package com.newsfeed.feed.data.di

import com.newsfeed.feed.data.NewsFeedRepositoryImpl
import com.newsfeed.feed.domain.NewsFeedRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindNewsFeedRepository(
        impl: NewsFeedRepositoryImpl
    ): NewsFeedRepository
}