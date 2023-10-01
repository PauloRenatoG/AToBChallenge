package com.example.atobchallenge.di

import android.content.Context
import com.example.atobchallenge.data.localdatasource.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = AppDataBase.build(context)

    @Provides
    fun provideProductDao(dataBase: AppDataBase) = dataBase.productDao()
}
