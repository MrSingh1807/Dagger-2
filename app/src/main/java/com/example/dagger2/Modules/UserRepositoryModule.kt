package com.example.dagger2.Modules

import com.example.dagger2.CustomQualifiers.FirebaseQualifier
import com.example.dagger2.FirebaseRepository
import com.example.dagger2.SQLRepository
import com.example.dagger2.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class UserRepositoryModule {

   companion object {
       @FirebaseQualifier
       @Provides
       fun getFirebaseRepository(): UserRepository {
           return FirebaseRepository()
       }
   }

    @Named("SQL")
    @Binds
    abstract fun getSQLRepository(sqlRepository: SQLRepository) : UserRepository
}