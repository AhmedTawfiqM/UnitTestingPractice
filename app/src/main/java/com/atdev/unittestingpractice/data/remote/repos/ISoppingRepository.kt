package com.atdev.unittestingpractice.data.remote.repos

import androidx.lifecycle.LiveData
import com.atdev.unittestingpractice.core.entities.ImageResponse
import com.atdev.unittestingpractice.data.local.ShoppingItem
import com.atdev.unittestingpractice.other.Resource

interface ISoppingRepository {
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)
    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)
    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>
    fun observeTotalPrice(): LiveData<Float>
    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>
}