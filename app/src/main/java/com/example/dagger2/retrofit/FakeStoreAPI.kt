package com.example.dagger2.retrofit

import com.example.dagger2.models.Product
import retrofit2.Response
import retrofit2.http.GET


interface FakeStoreAPI {

    @GET("products/")
    suspend fun getProducts() : Response<List<Product>>

}