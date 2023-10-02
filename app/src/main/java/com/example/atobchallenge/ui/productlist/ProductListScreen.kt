package com.example.atobchallenge.ui.productlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.atobchallenge.domain.model.Product
import com.example.atobchallenge.ui.design.CardProduct
import com.example.atobchallenge.ui.design.ErrorMessage
import com.example.atobchallenge.ui.theme.AToBChallengeTheme

@Composable
fun ProductListScreen(
    viewModel: ProductListViewModel,
    navigate: (Int?) -> Unit
) {

    LaunchedEffect(Unit) {
        viewModel.getProductList()
    }
    val state = viewModel.state.collectAsStateWithLifecycle()

    ProductListContent(state = state.value, navigate = navigate)
}

@Composable
fun ProductListContent(state: ProductListUiState, navigate: (Int?) -> Unit) {

    Scaffold {

        if (state.errorMessage != null) {
            ErrorMessage(message = state.errorMessage)
        }

        LazyColumn(
            contentPadding = PaddingValues(
                start = 16.dp,
                bottom = 16.dp,
                end = 16.dp,
                top = it.calculateTopPadding().plus(16.dp)
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = state.productList) { item ->
                CardProduct(
                    product = item,
                    onClick = { product -> navigate(product?.id) }
                )
            }
        }
    }
}

@Preview
@Composable
fun ProductListScreenPreview() {
    val list = listOf(
        Product(
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
        ),
        Product(
            id = 2,
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
    )
    val state = ProductListUiState(productList = list)

    AToBChallengeTheme {
        ProductListContent(state = state, navigate = {})
    }
}
