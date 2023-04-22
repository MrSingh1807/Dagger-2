package com.example.dagger2.modules

import android.content.Context
import androidx.room.Room
import com.example.dagger2.db.FakeStoreDAO
import com.example.dagger2.db.FakeStoreDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideFakeStoreDB(context : Context): FakeStoreDatabase {
        return Room.databaseBuilder(context, FakeStoreDatabase::class.java, "FakeStoreDB").build()
    }

    @Singleton
    @Provides
    fun provideFakeStoreDAO( database: FakeStoreDatabase) = database.getFakeStoreDao()

}