package com.example.atobchallenge.data.repository

import com.example.atobchallenge.data.localdatasource.ProductListLocalDataSource
import com.example.atobchallenge.data.remotedatasource.ProductListRemoteDataSource
import com.example.atobchallenge.data.util.AsyncResult
import com.example.atobchallenge.domain.model.Product
import com.example.atobchallenge.domain.repository.ProductsListRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever

class ProductRepositoryTest {

    @Mock
    private lateinit var dataSourceRemote: ProductListRemoteDataSource

    @Mock
    private lateinit var dataSourceLocal: ProductListLocalDataSource
    private lateinit var repository: ProductsListRepository

    private val dataSourceSuccess = AsyncResult.Success(listOf(product))
    private val dataSourceLocalSuccess = AsyncResult.Success(listOf(product))
    private val dataSourceError = AsyncResult.Error("Not found!")

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = ProductsListRepositoryImpl(dataSourceRemote, dataSourceLocal)
    }

    @Test
    fun `When local data source it is empty should call remote data source`() = runTest {
        whenever(dataSourceRemote.getProductList()).thenReturn(
            flowOf(dataSourceSuccess)
        )
        whenever(dataSourceLocal.getProductList()).thenReturn(
            AsyncResult.Success(listOf<Product>())
        )

        val response = repository.getProductList()

        response.collectLatest {
            assertEquals(it, dataSourceSuccess)
        }
    }

    @Test
    fun `When local data source it is not empty should return local product list`() = runTest {

        whenever(dataSourceLocal.getProductList()).thenReturn(
            dataSourceLocalSuccess
        )

        val response = repository.getProductList()

        response.collectLatest {
            assertEquals(it, dataSourceLocalSuccess)
        }
    }

    @Test
    fun `When it is an error load a message error`() = runTest {
        whenever(dataSourceRemote.getProductList()).thenReturn(
            flowOf(dataSourceError)
        )
        whenever(dataSourceLocal.getProductList()).thenReturn(
            AsyncResult.Success(listOf<Product>())
        )

        val response = repository.getProductList()

        response.collectLatest {
            assertEquals(it, dataSourceError)
        }
    }

    companion object {
        private val product = Product(
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
