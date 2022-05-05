package com.kumarrittik99.daggerwithmvvm.features.main.viewmodelfactories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kumarrittik99.daggerwithmvvm.features.main.repositories.ProductRepository
import com.kumarrittik99.daggerwithmvvm.features.main.viewmodels.MainViewModel
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val repository: ProductRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}