package com.example.dagger2.modules

import android.content.Context
import androidx.room.Room
import com.example.dagger2.db.FakeStoreDAO
import com.example.dagger2.db.FakeStoreDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideFakeStoreDB(@ApplicationContext context : Context): FakeStoreDatabase {
        return Room.databaseBuilder(context, FakeStoreDatabase::class.java, "FakeStoreDB").build()
    }

    @Singleton
    @Provides
    fun provideFakeStoreDAO( database: FakeStoreDatabase) = database.getFakeStoreDao()

}