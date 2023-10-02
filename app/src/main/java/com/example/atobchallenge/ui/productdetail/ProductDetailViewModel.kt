package com.example.atobchallenge.ui.productdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.atobchallenge.domain.usecase.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val useCase: GetProductUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ProductDetailUiState())
    val state = _state.asStateFlow()

    fun getProduct(id: Int) {
        viewModelScope.launch {
            val product = useCase(id)
            _state.update {
                it.copy(product = product)
            }
        }
    }
}
