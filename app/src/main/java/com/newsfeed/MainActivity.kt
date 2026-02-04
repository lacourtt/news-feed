package com.newsfeed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.newsfeed.feed.ui.NewsFeedViewModel
import com.newsfeed.ui.theme.NewsFeedTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsFeedTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NewsFeedScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun NewsFeedScreen(
    modifier: Modifier = Modifier,
    viewModel: NewsFeedViewModel = hiltViewModel()
) {
    // 1. Collect the flow to trigger the PagingSource load
    val newsItems = viewModel.newsPagingFlow.collectAsLazyPagingItems()

    // 2. A simple LazyColumn is enough to drive the paging events
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp)
    ) {
        // 3. Render items.
        // Accessing newsItems[index] is what triggers the next page load.
        items(count = newsItems.itemCount) { index ->
            val item = newsItems[index]

            if (item != null) {
                // Simple Text is enough to verify data is mapped correctly
                Text(
                    text = "DEBUG: ${item.toString()}",
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsFeedTheme {
        Greeting("Android")
    }
}