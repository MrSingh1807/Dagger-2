package com.example.dagger2.Modules

import com.example.dagger2.CustomQualifiers.FirebaseQualifier
import com.example.dagger2.FirebaseRepository
import com.example.dagger2.SQLRepository
import com.example.dagger2.UserRepository
import dagger.Binds
import dagger.Module
import javax.inject.Named
import javax.inject.Singleton

@Module
abstract class UserRepositoryModule {

    @FirebaseQualifier
    @Binds
    abstract fun getFirebaseRepository(firebaseRepository: FirebaseRepository): UserRepository

    @Named("SQL")
    @Singleton
    @Binds
    abstract fun getSQLRepository(sqlRepository: SQLRepository): UserRepository
}