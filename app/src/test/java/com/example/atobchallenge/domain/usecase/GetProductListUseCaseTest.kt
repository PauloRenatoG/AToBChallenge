package com.example.atobchallenge.domain.usecase

import com.example.atobchallenge.data.util.AsyncResult
import com.example.atobchallenge.domain.model.Product
import com.example.atobchallenge.domain.repository.ProductsListRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever

class GetProductListUseCaseTest {

    @Mock
    private lateinit var repository: ProductsListRepository
    private lateinit var useCase: GetProductListUseCase

    private val repositorySuccess = AsyncResult.Success(listOf<Product>())
    private val repositoryError = AsyncResult.Error("Not found!")

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetProductListUseCase(repository)
    }

    @Test
    fun `When repository it's successful should return a list`() = runTest {
        whenever(repository.getProductList()).thenReturn(
            flowOf(repositorySuccess)
        )

        val result = useCase()
        result.collectLatest {
            assertEquals(it, repositorySuccess)
        }
    }

    @Test
    fun `When repository it's error should return a error message`() = runTest {
        whenever(repository.getProductList()).thenReturn(
            flowOf(repositoryError)
        )

        val result = useCase()
        result.collectLatest {
            assertEquals(it, repositoryError)
        }
    }
}
