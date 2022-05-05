package com.kumarrittik99.daggerwithmvvm.data.remote

import com.kumarrittik99.daggerwithmvvm.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    @GET("products")
    suspend fun getProducts(): Response<List<Product>>
}