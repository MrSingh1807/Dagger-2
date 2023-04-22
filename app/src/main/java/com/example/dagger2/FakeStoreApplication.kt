package com.example.dagger2

import android.app.Application
import com.example.dagger2.components.ApplicationComponent
import com.example.dagger2.components.DaggerApplicationComponent

class FakeStoreApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this)

    }
}