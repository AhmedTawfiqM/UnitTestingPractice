package com.atdev.unittestingpractice.core.entities

import com.google.gson.annotations.SerializedName

data class ImageResult(
    val id: Int = 0,
    val webformatHeight: Int = 0,
    val imageWidth: Int = 0,
    val favorites: Int = 0,
    val previewHeight: Int = 0,
    val webformatURL: String = "",
    val userImageURL: String = "",
    val previewURL: String = "",
    val comments: Int = 0,
    val imageHeight: Int = 0,
    val tags: String = "",
    val previewWidth: Int = 0,
    val fullHDURL: String = "",
    val downloads: Int = 0,
    @SerializedName("user_id")
    val userId: Int = 0,
    val type: String = "",
    val largeImageURL: String = "",
    val imageURL: String = "",
    val pageURL: String = "",
    val imageSize: Int = 0,
    val webformatWidth: Int = 0,
    val user: String = "",
    val views: Int = 0,
    val likes: Int = 0
)