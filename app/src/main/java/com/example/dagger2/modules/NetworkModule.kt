package com.example.dagger2.modules

import com.example.dagger2.retrofit.FakeStoreAPI
import com.example.dagger2.utils.Utils.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideFakeStoreAPI(retrofit: Retrofit): FakeStoreAPI {
        return retrofit.create(FakeStoreAPI::class.java)
    }
}