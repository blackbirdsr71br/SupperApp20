package com.alex.dashboarddemo.ui.stories

data class Tweet(
    val id: Int,
    val text: String,
    val author: String,
    val handle: String,
    val time: String,
    val authorImageId: Int,
    val likesCount: Int,
    val commentsCount: Int,
    val retweetCount: Int,
    val source: String,
    val tweetImageId: Int = 0
)