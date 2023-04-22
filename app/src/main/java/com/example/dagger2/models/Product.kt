package com.example.dagger2.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Product")
data class Product(
    val category: String,
    val description: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)