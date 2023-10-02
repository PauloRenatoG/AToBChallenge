package com.example.atobchallenge.ui.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.atobchallenge.data.util.AsyncResult
import com.example.atobchallenge.domain.usecase.GetProductListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val useCase: GetProductListUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ProductListUiState())
    val state = _state.asStateFlow()

    fun getProductList() {
        viewModelScope.launch {
            val result = useCase()
            result.collectLatest { result ->
                when (result) {
                    is AsyncResult.Success -> {
                        _state.update {
                            it.copy(productList = result.data ?: listOf(), errorMessage = null)
                        }
                    }

                    is AsyncResult.Error -> {
                        _state.update {
                            it.copy(errorMessage = result.message)
                        }
                    }
                }
            }
        }
    }
}
