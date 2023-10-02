package com.example.atobchallenge.domain.usecase

import com.example.atobchallenge.domain.model.Product
import com.example.atobchallenge.domain.repository.ProductRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

class GetProductUseCaseTest {

    @Mock
    private lateinit var repository: ProductRepository
    private lateinit var useCase: GetProductUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetProductUseCase(repository)
    }

    @Test
    fun `When repository it's successful should return a product`() = runTest {
        whenever(repository.getProduct(any())).thenReturn(
            repositorySuccess
        )

        val result = useCase(any())
        assertEquals(result, repositorySuccess)
    }

    companion object {
        private val repositorySuccess = Product(
            id = 1,
            title = "iPhone 9",
            description = "An apple mobile which is nothing like apple",
            price = 549,
            discountPercentage = 12.96,
            rating = 4.60,
            stock = 94,
            brand = "Apple",
            category = "smartphones",
            thumbnail = "https://i.dummyjson.com/data/products/1/thumbnail.jpg",
            images = listOf("https://i.dummyjson.com/data/products/1/2.jpg")
        )
    }
}
