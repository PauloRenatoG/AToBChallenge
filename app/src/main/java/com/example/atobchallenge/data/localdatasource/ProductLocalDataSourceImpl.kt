package com.example.atobchallenge.data.localdatasource

import com.example.atobchallenge.data.mapper.mapToDomain
import com.example.atobchallenge.domain.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductLocalDataSourceImpl @Inject constructor(
    private val productDao: ProductDao
): ProductLocalDataSource {

    override suspend fun getProduct(id: Int): Product {
        return withContext(Dispatchers.IO) {
            productDao.getProduct(id).mapToDomain()
        }
    }
}