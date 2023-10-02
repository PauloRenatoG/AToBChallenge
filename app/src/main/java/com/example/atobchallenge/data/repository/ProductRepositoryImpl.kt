package com.example.atobchallenge.data.repository

import com.example.atobchallenge.data.localdatasource.ProductLocalDataSource
import com.example.atobchallenge.domain.model.Product
import com.example.atobchallenge.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productLocalDataSource: ProductLocalDataSource
) : ProductRepository {

    override suspend fun getProduct(id: Int): Product {
        return productLocalDataSource.getProduct(id)
    }
}