package com.example.atobchallenge.data.remotedatasource

import com.example.atobchallenge.data.AToBeService
import com.example.atobchallenge.data.mapper.mapToDomain
import com.example.atobchallenge.data.util.AsyncResult
import com.example.atobchallenge.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductListRemoteDataSourceImpl @Inject constructor(
    private val service: AToBeService
): ProductListRemoteDataSource {

    override suspend fun getProductList(): Flow<AsyncResult<List<Product?>>> {
        return flow {
            val result = service.getProductsList()
            if (result.isSuccessful) {
                emit(
                    AsyncResult.Success(result.body()?.products?.mapToDomain())
                )
            } else {
                emit(
                    AsyncResult.Error(result.errorBody()?.string())
                )
            }
        }
    }
}
