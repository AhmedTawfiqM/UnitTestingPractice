package com.atdev.unittestingpractice.data

import com.atdev.unittestingpractice.data.local.ShoppingDao
import com.atdev.unittestingpractice.data.remote.network.PixabayApi

data class DataManager(
    val shoppingDao: ShoppingDao,
    val pixabayApi: PixabayApi
)