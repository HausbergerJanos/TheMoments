package com.application.themoments.model

data class FeedItem(
    override val id: Int,
    val text: String
) : Identifiable