package com.example.atobchallenge.data.localdatasource

import com.example.atobchallenge.data.mapper.mapToDao
import com.example.atobchallenge.data.mapper.mapToDomain
import com.example.atobchallenge.data.util.AsyncResult
import com.example.atobchallenge.domain.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductListLocalDataSourceImpl @Inject constructor(
    private val productDao: ProductDao
) : ProductListLocalDataSource {

    override suspend fun getProductList(): AsyncResult<List<Product?>> {
        return withContext(Dispatchers.IO) {
            AsyncResult.Success(productDao.getProductList().mapToDomain())
        }
    }

    override suspend fun insertAll(productList: List<Product?>) {
        withContext(Dispatchers.IO) {
            productDao.insertAll(productList.mapToDao())
        }
    }
}
