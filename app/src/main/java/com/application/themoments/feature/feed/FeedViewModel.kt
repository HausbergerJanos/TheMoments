package com.application.themoments.feature.feed

import androidx.lifecycle.ViewModel
import com.application.themoments.model.FeedItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FeedViewModel
@Inject
constructor() : ViewModel() {

    private val _test: MutableStateFlow<List<FeedItem>> = MutableStateFlow(
        listOf(
            FeedItem(0, "1"),
            FeedItem(1, "2"),
            FeedItem(2, "3"),
            FeedItem(3, "4"),
            FeedItem(4, "5"),
            FeedItem(5, "6"),
            FeedItem(6, "7"),
            FeedItem(7, "8"),
            FeedItem(8, "9"),
            FeedItem(9, "10"),
            FeedItem(10, "11"),
            FeedItem(11, "12"),
            FeedItem(12, "13"),
            FeedItem(13, "14"),
            FeedItem(14, "15"),
            FeedItem(15, "16"),
            FeedItem(16, "17"),
            FeedItem(17, "18"),
            FeedItem(18, "19"),
            FeedItem(19, "20")
        )
    )
    val test = _test.asStateFlow()
}