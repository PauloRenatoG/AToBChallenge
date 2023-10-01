package com.example.atobchallenge.di

import com.example.atobchallenge.data.localdatasource.ProductListLocalDataSource
import com.example.atobchallenge.data.localdatasource.ProductListLocalDataSourceImpl
import com.example.atobchallenge.data.remotedatasource.ProductListRemoteDataSource
import com.example.atobchallenge.data.remotedatasource.ProductListRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindProductListRemoteDataSource(
        dataSource: ProductListRemoteDataSourceImpl
    ): ProductListRemoteDataSource

    @Binds
    fun bindProductListLocalDataSource(
        dataSource: ProductListLocalDataSourceImpl
    ): ProductListLocalDataSource
}
