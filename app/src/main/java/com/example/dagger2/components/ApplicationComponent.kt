package com.example.dagger2.components

import android.content.Context
import com.example.dagger2.MainActivity
import com.example.dagger2.modules.DatabaseModule
import com.example.dagger2.modules.NetworkModule
import com.example.dagger2.modules.ViewModelModules
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component (modules = [NetworkModule::class, DatabaseModule::class, ViewModelModules::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context : Context): ApplicationComponent
    }
}