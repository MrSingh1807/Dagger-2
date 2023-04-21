package com.example.dagger2

import android.util.Log
import com.example.dagger2.Constants.Companion.TAG
import javax.inject.Inject

interface UserRepository {
    fun saveUser(name: String, password: String)
}
class SQLRepository @Inject constructor() : UserRepository{
    override fun saveUser(name: String, password: String) {
        Log.d(TAG," User Saved in SQL")
    }
}

class FirebaseRepository: UserRepository{
    override fun saveUser(name: String, password: String) {
        Log.d(TAG," User Saved in Firebase")
    }

}