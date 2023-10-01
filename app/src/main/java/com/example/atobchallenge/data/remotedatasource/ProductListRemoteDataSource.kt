package com.example.atobchallenge.data.remotedatasource

import com.example.atobchallenge.data.util.AsyncResult
import com.example.atobchallenge.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductListRemoteDataSource {

    suspend fun getProductList(): Flow<AsyncResult<List<Product?>>>
}
