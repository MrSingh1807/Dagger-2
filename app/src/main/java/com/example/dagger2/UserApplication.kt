package com.example.dagger2

import android.app.Application
import com.example.dagger2.Modules.AnalyticsModule
import com.example.dagger2.component.AppComponent
import com.example.dagger2.component.DaggerAppComponent

class UserApplication: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()
    }
}