package com.atdev.unittestingpractice.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_item")
data class ShoppingItem(
    val name: String,
    val amount: Double,
    val price: Double,
    val imageUrl: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)