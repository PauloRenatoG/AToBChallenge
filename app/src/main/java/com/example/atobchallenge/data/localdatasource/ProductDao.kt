package com.example.atobchallenge.data.localdatasource

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.atobchallenge.data.model.ProductResponse

@Dao
interface ProductDao {

    @Upsert
    fun insertAll(productList: List<ProductResponse?>)

    @Query("SELECT * FROM product")
    fun getProductList(): List<ProductResponse>

    @Query("SELECT * FROM product WHERE id = :id")
    fun getProduct(id: Int): ProductResponse
}
