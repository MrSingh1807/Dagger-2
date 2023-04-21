package com.example.dagger2

import android.util.Log
import com.example.dagger2.Constants.Companion.TAG
import com.example.dagger2.Service.AnalyticsService
import com.example.dagger2.scopes.ActivityScope
import com.example.dagger2.scopes.ApplicationScope
import javax.inject.Inject
import javax.inject.Singleton

interface UserRepository {
    fun saveUser(name: String, password: String)
}

@ActivityScope
class SQLRepository @Inject constructor(private val analyticsService: AnalyticsService) : UserRepository {
    override fun saveUser(name: String, password: String) {
        Log.d(TAG, "User Saved in SQL")
        analyticsService.trackEvent("Save User", "CREATE" )
    }
}

class FirebaseRepository @Inject constructor(private val analyticsService: AnalyticsService) : UserRepository {
    override fun saveUser(name: String, password: String) {
        Log.d(TAG, " User Saved in Firebase")
        analyticsService.trackEvent("Save User", "CREATE" )

    }

}