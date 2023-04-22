package com.example.dagger2.repositories

import com.example.dagger2.db.datasource.LocalDataSource
import com.example.dagger2.retrofit.datasource.RemoteDataSource
import javax.inject.Inject


class ProductRepository @Inject constructor(
    localDataSource: LocalDataSource,
    remoteDataSource: RemoteDataSource
) {
    val localData = localDataSource
    val remoteData = remoteDataSource

}