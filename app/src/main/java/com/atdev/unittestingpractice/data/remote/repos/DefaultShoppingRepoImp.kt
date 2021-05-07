package com.atdev.unittestingpractice.data.remote.repos

import androidx.lifecycle.LiveData
import com.atdev.unittestingpractice.core.entities.ImageResponse
import com.atdev.unittestingpractice.data.DataManager
import com.atdev.unittestingpractice.data.local.ShoppingItem
import com.atdev.unittestingpractice.other.Resource
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class DefaultShoppingRepoImp @Inject constructor(
    private val dataManager: DataManager
) : ISoppingRepository {

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        dataManager.shoppingDao.insertShoppingItem(shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        dataManager.shoppingDao.deleteShoppingItem(shoppingItem)
    }

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
        return dataManager.shoppingDao.observeAllShoppingItems()
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return dataManager.shoppingDao.observeTotalPrice()
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
        return try {
            val response = dataManager.pixabayApi.searchImages(searchKey = imageQuery)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("an unKnown error occured", null)
            } else
                Resource.error("an unKnown error occured", null)
        } catch (ex: Exception) {
            Resource.error("couldn't reach the server", null)
        }
    }
}