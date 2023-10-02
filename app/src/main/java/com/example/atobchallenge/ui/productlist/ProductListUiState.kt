package com.example.atobchallenge.ui.productlist

import com.example.atobchallenge.domain.model.Product

data class ProductListUiState(
    val productList: List<Product?> = listOf(),
    val errorMessage: String? = null
)
