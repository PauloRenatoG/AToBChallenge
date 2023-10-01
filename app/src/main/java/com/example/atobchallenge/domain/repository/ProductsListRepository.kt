package com.example.atobchallenge.domain.repository

import com.example.atobchallenge.data.util.AsyncResult
import com.example.atobchallenge.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsListRepository {

    suspend fun getProductList(): Flow<AsyncResult<List<Product?>>>
}
