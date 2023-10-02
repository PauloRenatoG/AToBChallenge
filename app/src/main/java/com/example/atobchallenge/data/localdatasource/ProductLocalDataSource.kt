package com.example.atobchallenge.data.localdatasource

import com.example.atobchallenge.domain.model.Product

interface ProductLocalDataSource {

    suspend fun getProduct(id: Int): Product
}
