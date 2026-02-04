package com.newsfeed.feed.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.newsfeed.feed.data.NewsFeedService
import com.newsfeed.feed.data.dto.toDomainObject
import com.newsfeed.feed.domain.domainobjects.NewsItem
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class CursorBasedPagingSource @Inject constructor(
    private val service: NewsFeedService
) : PagingSource<String, NewsItem>() {

    private val PATTERN_PREV = "rel=\"prev\""
    private val PATTERN_NEXT = "rel=\"next\""

    override fun getRefreshKey(state: PagingState<String, NewsItem>): String? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, NewsItem> {
        val currentUrl = params.key ?: "/api/v1/timelines/tag/news?language=en-US&limit=40"

        return try {
            val response = service.getNews(currentUrl)

            if (response.isSuccessful) {
                val data = if (response.body().isNullOrEmpty()) {
                    emptyList()
                } else {
                    response.body()!!.map { dto -> dto.toDomainObject() }
                }
                val linkHeader = response.headers()["Link"]

                val prevUrl = parseHeader(linkHeader, PATTERN_PREV)
                val nextUrl = parseHeader(linkHeader, PATTERN_NEXT)

                LoadResult.Page(data, prevUrl, nextUrl)
            } else {
                LoadResult.Error(HttpException(response))
            }
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    private fun parseHeader(linkHeader: String?, pattern: String): String? {
        if (linkHeader == null) return null

        // Look for the part of the header that contains rel="next"
        val links = linkHeader.split(",")
        val nextLink = links.find { it.contains(pattern) } ?: return null

        // Extract the value of the max_id query parameter using Regex
        val pattern = "max_id=([^&>]+)".toRegex()
        return pattern.find(nextLink)?.groupValues?.get(1)
    }
}