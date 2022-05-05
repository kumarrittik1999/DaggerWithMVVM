package com.kumarrittik99.daggerwithmvvm.features.main.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kumarrittik99.daggerwithmvvm.data.remote.FakerAPI
import com.kumarrittik99.daggerwithmvvm.models.Product
import javax.inject.Inject

class ProductRepository @Inject constructor(private val api: FakerAPI) {

    private val _productsLiveData = MutableLiveData<List<Product>>()
    val productsLiveData: LiveData<List<Product>>
        get() = _productsLiveData

    suspend fun getProducts() {
        val result = api.getProducts()
        if(result.isSuccessful && result.body() != null) {
            _productsLiveData.postValue(result.body())
        }
    }
}