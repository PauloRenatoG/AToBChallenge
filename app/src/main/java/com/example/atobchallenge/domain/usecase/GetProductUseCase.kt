package com.example.atobchallenge.domain.usecase

import com.example.atobchallenge.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    suspend operator fun invoke(id: Int) = repository.getProduct(id)
}