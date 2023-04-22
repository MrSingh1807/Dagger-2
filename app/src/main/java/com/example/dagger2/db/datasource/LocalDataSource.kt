package com.example.dagger2.db.datasource

import com.example.dagger2.db.FakeStoreDAO
import com.example.dagger2.models.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class LocalDataSource @Inject constructor(
    private val fakeStoreDAO: FakeStoreDAO
) {

    suspend fun addProducts(products: List<Product>) {
        fakeStoreDAO.addProducts(products)
    }

    fun readProducts() : Flow<List<Product>> {
        return fakeStoreDAO.getProducts()
    }

}