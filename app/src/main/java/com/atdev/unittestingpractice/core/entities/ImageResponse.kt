package com.atdev.unittestingpractice.core.entities

data class ImageResponse(
    val total: Int = 0,
    val totalHits: Int = 0,
    val hits: List<ImageResult>,
)