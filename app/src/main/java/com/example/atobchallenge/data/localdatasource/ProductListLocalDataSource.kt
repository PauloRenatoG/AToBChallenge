package com.example.atobchallenge.data.localdatasource

import com.example.atobchallenge.data.util.AsyncResult
import com.example.atobchallenge.domain.model.Product

interface ProductListLocalDataSource {

    suspend fun getProductList(): AsyncResult<List<Product?>>

    suspend fun insertAll(productList: List<Product?>)
}
