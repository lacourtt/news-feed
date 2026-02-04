package com.newsfeed.feed.data.di

import com.newsfeed.feed.domain.GetNewsFeedUseCase
import com.newsfeed.feed.domain.GetNewsFeedUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindGetNewsFeedUseCase(
        impl: GetNewsFeedUseCaseImpl
    ): GetNewsFeedUseCase
}