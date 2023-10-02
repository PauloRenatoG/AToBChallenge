package com.example.atobchallenge.di

import com.example.atobchallenge.data.repository.ProductRepositoryImpl
import com.example.atobchallenge.data.repository.ProductsListRepositoryImpl
import com.example.atobchallenge.domain.repository.ProductRepository
import com.example.atobchallenge.domain.repository.ProductsListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindProductListRepository(
        repository: ProductsListRepositoryImpl
    ): ProductsListRepository

    @Binds
    fun bindProductRepository(
        repository: ProductRepositoryImpl
    ): ProductRepository
}
