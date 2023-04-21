package com.example.dagger2

import android.app.Application

class UserApplication: Application() {
    lateinit var userRegistrationComponents: UserRegistrationComponents

    override fun onCreate() {
        super.onCreate()

        userRegistrationComponents = DaggerUserRegistrationComponents.factory().create(3)
    }
}