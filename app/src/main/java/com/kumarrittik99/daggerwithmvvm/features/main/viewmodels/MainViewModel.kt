package com.kumarrittik99.daggerwithmvvm.features.main.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kumarrittik99.daggerwithmvvm.features.main.repositories.ProductRepository
import com.kumarrittik99.daggerwithmvvm.models.Product
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository): ViewModel() {

    val productsLiveData: LiveData<List<Product>>
    get() = repository.productsLiveData

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}