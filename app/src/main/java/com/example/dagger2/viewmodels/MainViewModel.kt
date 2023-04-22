package com.example.dagger2.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.dagger2.models.Product
import com.example.dagger2.repositories.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
    private val repository: ProductRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.remoteData.getProducts()
        }
    }

    val productsRemoteData: LiveData<List<Product>>
        get() = repository.remoteData.products

    fun offlineSaveData(response : List<Product>?) {
        if (!response.isNullOrEmpty()) {
            viewModelScope.launch(Dispatchers.IO) {
                repository.localData.addProducts(response)
            }
        }
    }

    val productsLocalDB = repository.localData.readProducts().asLiveData()

}