package com.example.dagger2.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dagger2.models.Product
import kotlinx.coroutines.flow.Flow


@Dao
interface FakeStoreDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products: List<Product>)

    @Query("SELECT * FROM Product" )
    fun getProducts() : Flow<List<Product>>
}