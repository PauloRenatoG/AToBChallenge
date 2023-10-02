package com.example.atobchallenge.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(val route: String) {

    object ProductListScreen : Screen("product_list")

    object ProductDetail : Screen("product_detail/{product_id}") {
        val arguments = listOf(
            navArgument("product_id") {
                type = NavType.IntType
            }
        )

        fun createRoute(productId: Int?) = "product_detail/$productId"
    }
}
