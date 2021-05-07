package com.atdev.unittestingpractice.di

import android.content.Context
import androidx.room.Room
import com.atdev.unittestingpractice.data.local.ShoppingDatabase
import com.atdev.unittestingpractice.data.other.Constants.BASE_URL
import com.atdev.unittestingpractice.data.other.Constants.DATABASE_NAME
import com.atdev.unittestingpractice.data.remote.network.PixabayApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ShoppingDatabase::class.java, DATABASE_NAME)
            .build()

    @Singleton
    @Provides
    fun provideShoppingDao(database: ShoppingDatabase) =
        database.shoppingDao()

    @Singleton
    @Provides
    fun providePixabayApi() =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PixabayApi::class.java)

}