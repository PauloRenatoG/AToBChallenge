package com.example.atobchallenge.data.repository

import com.example.atobchallenge.data.remotedatasource.ProductListRemoteDataSource
import com.example.atobchallenge.data.util.AsyncResult
import com.example.atobchallenge.domain.model.Product
import com.example.atobchallenge.domain.repository.ProductsListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsListRepositoryImpl @Inject constructor(
    private val productRemoteDataSource: ProductListRemoteDataSource
): ProductsListRepository {

    override suspend fun getProductList(): Flow<AsyncResult<List<Product?>>> {
        return productRemoteDataSource.getProductList()
    }
}
