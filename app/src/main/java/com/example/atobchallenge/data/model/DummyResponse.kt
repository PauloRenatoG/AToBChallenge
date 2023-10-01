package com.example.atobchallenge.data.model

import com.google.gson.annotations.SerializedName

data class DummyResponse(
    @SerializedName("products")
    val products: List<ProductResponse?>?
)
