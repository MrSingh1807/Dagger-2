package com.example.dagger2

import android.util.Log
import com.example.dagger2.Constants.Companion.TAG
import com.example.dagger2.scopes.ApplicationScope
import javax.inject.Inject
import javax.inject.Singleton

interface UserRepository {
    fun saveUser(name: String, password: String)
}

@ApplicationScope
class SQLRepository @Inject constructor() : UserRepository {
    override fun saveUser(name: String, password: String) {
        Log.d(TAG, "User Saved in SQL")
    }
}

class FirebaseRepository @Inject constructor() : UserRepository {
    override fun saveUser(name: String, password: String) {
        Log.d(TAG, " User Saved in Firebase")
    }

}