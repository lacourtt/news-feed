package com.newsfeed.feed.data.di

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.newsfeed.feed.data.datasource.CursorBasedPagingSource
import com.newsfeed.feed.domain.domainobjects.NewsItem
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Provider
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PagingModule {
    @Provides
    fun providePagingConfig(): PagingConfig {
        return PagingConfig(
            pageSize = 40,
            enablePlaceholders = false
        )
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class NewsPager

    @Provides
    @Singleton
    @NewsPager
    fun provideNewsPager(
        pagingConfig: PagingConfig,
        pagingSourceFactory: Provider<CursorBasedPagingSource>
    ): Pager<String, NewsItem> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { pagingSourceFactory.get() }
        )
    }
}