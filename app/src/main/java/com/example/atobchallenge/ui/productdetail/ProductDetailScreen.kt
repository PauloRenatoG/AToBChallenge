package com.example.atobchallenge.ui.productdetail

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.atobchallenge.R
import com.example.atobchallenge.domain.model.Product
import com.example.atobchallenge.ui.design.RatingBar
import com.example.atobchallenge.ui.theme.AToBChallengeTheme
import com.example.atobchallenge.ui.theme.Typography

@Composable
fun ProductDetailScreen(viewModel: ProductDetailViewModel, productId: Int) {

    LaunchedEffect(Unit) {
        viewModel.getProduct(productId)
    }
    val state = viewModel.state.collectAsStateWithLifecycle()
    ProductDetailContent(state = state.value)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailContent(state: ProductDetailUiState) {

    Scaffold(
        topBar = {
            TopAppBar(title = { state.product?.title?.let { Text(text = it) } })
        }
    ) { paddingValue ->
        Column(
            modifier = Modifier
                .padding(top = paddingValue.calculateTopPadding())
                .padding(horizontal = 16.dp)
                .verticalScroll(ScrollState(0)),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = state.product?.thumbnail,
                placeholder = painterResource(id = R.drawable.ic_broken_image),
                contentDescription = null
            )

            state.product?.description?.let {
                Text(text = it, style = Typography.bodyLarge)
            }

            state.product?.rating?.let {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = stringResource(id = R.string.rating), style = Typography.bodySmall)
                    RatingBar(rating = it.toInt())
                }
            }

            state.product?.brand?.let {
                Text(text = stringResource(id = R.string.brand, it), style = Typography.bodySmall)
            }

            state.product?.category?.let {
                Text(
                    text = stringResource(id = R.string.category, it),
                    style = Typography.bodySmall
                )
            }

            state.product?.price?.let {
                Text(text = stringResource(id = R.string.price, it), style = Typography.bodySmall)
            }

            state.product?.discountPercentage?.let {
                Text(
                    text = stringResource(id = R.string.discount, it.toFloat()),
                    style = Typography.bodySmall
                )
            }

            state.product?.stock?.let {
                Text(text = stringResource(id = R.string.stock, it), style = Typography.bodySmall)
            }

            state.product?.images?.let {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(items = it) { image ->
                        AsyncImage(
                            modifier = Modifier.size(100.dp),
                            model = image,
                            placeholder = painterResource(id = R.drawable.ic_broken_image),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ProductDetailScreenPreview() {
    val product = Product(
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
    val state = ProductDetailUiState(product = product)

    AToBChallengeTheme {
        ProductDetailContent(state = state)
    }
}
