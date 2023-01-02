package com.aristotele.foodappmvp.retrofit.utils.di

import com.aristotele.foodappmvp.retrofit.data.database.FoodDatabase
import com.aristotele.foodappmvp.retrofit.data.database.FoodEntity
import android.content.Context
import androidx.room.Room
import com.aristotele.foodappmvp.retrofit.utils.FOOD_DB_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, FoodDatabase::class.java, FOOD_DB_DATABASE
    ).allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideDao(db: FoodDatabase) = db.foodDao()

    @Provides
    @Singleton
    fun provideEntity() = FoodEntity()
}