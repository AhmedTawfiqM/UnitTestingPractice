package com.atdev.unittestingpractice.remote.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atdev.unittestingpractice.core.entities.ImageResponse
import com.atdev.unittestingpractice.data.local.ShoppingItem
import com.atdev.unittestingpractice.data.remote.repos.ISoppingRepository
import com.atdev.unittestingpractice.other.Resource

class FakeShoppingRepo : ISoppingRepository {

    private val shoppingItems = mutableListOf<ShoppingItem>()
    private val observableShoppingItem = MutableLiveData<List<ShoppingItem>>(shoppingItems)
    private val observableTotalPrice = MutableLiveData<Float>()

    private var shouldReturnNetworkError = false

    fun shouldReturnNetworkError(value: Boolean) {
        shouldReturnNetworkError = value
    }

    private fun refresh() {
        observableShoppingItem.postValue(shoppingItems)
        observableTotalPrice.postValue(getTotalPrice())
    }

    private fun getTotalPrice(): Float {
        return shoppingItems.sumByDouble { it.price }.toFloat()
    }

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingItems.add(shoppingItem)
        refresh()
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingItems.remove(shoppingItem)
        refresh()
    }

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
        return observableShoppingItem
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return observableTotalPrice
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
        return if (shouldReturnNetworkError) {
            Resource.error("Error", null)
        } else {
            Resource.success(ImageResponse(0, 0, emptyList()))
        }
    }

}