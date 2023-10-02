package com.example.atobchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.atobchallenge.ui.productdetail.ProductDetailScreen
import com.example.atobchallenge.ui.productdetail.ProductDetailViewModel
import com.example.atobchallenge.ui.productlist.ProductListScreen
import com.example.atobchallenge.ui.productlist.ProductListViewModel

@Composable
fun Navigation(navController: NavHostController, startDestination: String) {

    NavHost(navController = navController, startDestination = startDestination) {

        composable(Screen.ProductListScreen.route) {
            val viewModel = hiltViewModel<ProductListViewModel>()
            ProductListScreen(viewModel = viewModel) { productId ->
                navController.navigate(Screen.ProductDetail.createRoute(productId))
            }
        }

        composable(
            route = Screen.ProductDetail.route,
            arguments = Screen.ProductDetail.arguments
        ) { backStackEntry ->
            val viewModel = hiltViewModel<ProductDetailViewModel>()
            val productId = backStackEntry.arguments?.getInt("product_id")
            if (productId != null) {
                ProductDetailScreen(viewModel = viewModel, productId = productId)
            }
        }
    }
}
