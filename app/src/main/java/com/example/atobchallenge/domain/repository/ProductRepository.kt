package com.example.atobchallenge.domain.repository

import com.example.atobchallenge.domain.model.Product

interface ProductRepository {

    suspend fun getProduct(id: Int): Product
}