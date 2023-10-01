package com.example.atobchallenge.ui.design

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.atobchallenge.R

@Composable
fun RatingBar(
    rating: Int
) {
    Row {
        for (rate in 1..rating) {
            Icon(painter = painterResource(id = R.drawable.ic_star_rate), contentDescription = "")
        }
    }
}
