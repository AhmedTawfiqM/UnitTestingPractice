package com.atdev.unittestingpractice.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun shoppingDao(): ShoppingDao
}