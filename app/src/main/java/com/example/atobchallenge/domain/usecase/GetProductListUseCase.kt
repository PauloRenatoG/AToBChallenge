package com.example.atobchallenge.domain.usecase

import com.example.atobchallenge.domain.repository.ProductsListRepository
import javax.inject.Inject

class GetProductListUseCase @Inject constructor(
    private val repository: ProductsListRepository
) {

    suspend operator fun invoke() = repository.getProductList()
}
