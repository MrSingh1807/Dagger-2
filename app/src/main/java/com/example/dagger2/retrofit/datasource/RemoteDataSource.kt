package com.example.dagger2.retrofit.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dagger2.models.Product
import com.example.dagger2.retrofit.FakeStoreAPI
import javax.inject.Inject


class RemoteDataSource @Inject constructor (
    private val fakeStoreAPI: FakeStoreAPI
    ) {

    private val _products = MutableLiveData<List<Product>>()
    val products : LiveData<List<Product>>
        get() = _products

    suspend fun getProducts(){
        val result = fakeStoreAPI.getProducts()
        if (result.isSuccessful && !result.body().isNullOrEmpty()){
            _products.postValue(result.body())
        }
    }
}
