package com.newsfeed.feed.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.newsfeed.feed.domain.domainobjects.NewsItem
import com.newsfeed.feed.domain.GetNewsFeedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class NewsFeedViewModel @Inject constructor(
    getNewsFeedUseCase: GetNewsFeedUseCase
): ViewModel() {
    val newsPagingFlow: Flow<PagingData<NewsItem>> = getNewsFeedUseCase().cachedIn(viewModelScope)
}
