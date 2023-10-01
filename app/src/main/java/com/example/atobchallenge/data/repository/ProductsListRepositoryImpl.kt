package com.example.atobchallenge.data.repository

import com.example.atobchallenge.data.localdatasource.ProductListLocalDataSource
import com.example.atobchallenge.data.remotedatasource.ProductListRemoteDataSource
import com.example.atobchallenge.data.util.AsyncResult
import com.example.atobchallenge.domain.model.Product
import com.example.atobchallenge.domain.repository.ProductsListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class ProductsListRepositoryImpl @Inject constructor(
    private val productRemoteDataSource: ProductListRemoteDataSource,
    private val productLocalDataSource: ProductListLocalDataSource
) : ProductsListRepository {

    override suspend fun getProductList(): Flow<AsyncResult<List<Product?>>> {
        val resultLocal = productLocalDataSource.getProductList() as AsyncResult.Success
        return if (resultLocal.data.isNullOrEmpty()) {
            val resultRemote = productRemoteDataSource.getProductList()
            resultRemote.collectLatest { result ->
                if (result is AsyncResult.Success) result.data?.let {
                    productLocalDataSource.insertAll(it)
                }
            }
            resultRemote
        } else {
            flowOf(resultLocal)
        }
    }
}
