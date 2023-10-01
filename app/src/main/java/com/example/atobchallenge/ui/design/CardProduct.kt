package com.example.atobchallenge.ui.design

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.atobchallenge.R
import com.example.atobchallenge.domain.model.Product
import com.example.atobchallenge.ui.theme.Typography

@Composable
fun CardProduct(
    modifier: Modifier = Modifier,
    product: Product?,
    onClick: (Product?) -> Unit
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick.invoke(product)
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AsyncImage(
                modifier = Modifier.size(100.dp).clip(RoundedCornerShape(12.dp)),
                model = product?.thumbnail,
                placeholder = painterResource(id = R.drawable.ic_broken_image),
                contentDescription = null
            )
            Column {
                product?.title?.let {
                    Text(
                        text = it,
                        maxLines = 1,
                        style = Typography.titleLarge,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                product?.rating?.let {
                    RatingBar(rating = it.toInt())
                }
            }
        }
    }
}

@Preview
@Composable
fun CardProductPreview() {
    val product = Product(
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

    CardProduct(product = product, onClick = {})
}
