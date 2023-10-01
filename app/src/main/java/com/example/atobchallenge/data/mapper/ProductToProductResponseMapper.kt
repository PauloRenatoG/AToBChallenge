package com.example.atobchallenge.data.mapper

import com.example.atobchallenge.data.model.ProductResponse
import com.example.atobchallenge.domain.model.Product

fun Product.mapToDao() = ProductResponse(
    brand = this.brand,
    category = this.category,
    description = this.description,
    discountPercentage = this.discountPercentage,
    id = this.id,
    images = this.images ?: listOf(),
    price = this.price,
    rating = this.rating,
    stock = this.stock,
    thumbnail = this.thumbnail,
    title = this.title
)

fun List<Product?>.mapToDao() = this.map { it?.mapToDao() }
