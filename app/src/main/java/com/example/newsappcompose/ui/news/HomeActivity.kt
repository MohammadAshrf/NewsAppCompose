package com.example.newsappcompose.ui.news

import android.app.ActionBar.Tab
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.api.model.sourcesResponse.Source
import com.example.newsappcompose.ui.theme.NewsAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppComposeTheme {

            }
        }
    }
}

@Composable
fun NewsSourcesTabs(sourcesItemList: List<Source>) {
    var selectedIndex = 0
    ScrollableTabRow(selectedTabIndex = selectedIndex, containerColor = Color.Transparent) {
        sourcesItemList.forEachIndexed { index, source ->
            Tab(
                selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                },
                modifier = if (selectedIndex == index) Modifier
                    .padding(end = 2.dp)
                    .background(
                        Color(0xFF39A552),
                        RoundedCornerShape(50)
                    )
                else Modifier
                    .padding(end = 2.dp)
                    .border(2.dp, Color(0xFF39A552), RoundedCornerShape(50)),

            ) {

            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    NewsAppComposeTheme {
        NewsSourcesTabs(
            sourcesItemList = listOf(
                Source(name = "Sports News"),
                Source(name = "Sports News"),
                Source(name = "Sports News"),
                Source(name = "Sports News"),
                Source(name = "Sports News"),
                Source(name = "Sports News"),
            )
        )
    }
}