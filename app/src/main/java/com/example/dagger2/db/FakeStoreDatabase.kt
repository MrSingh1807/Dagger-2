package com.example.dagger2.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dagger2.models.Product


@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class FakeStoreDatabase : RoomDatabase() {

    abstract fun getFakeStoreDao(): FakeStoreDAO
}