package com.example.dagger2.component

import com.example.dagger2.Modules.AnalyticsModule
import com.example.dagger2.Service.AnalyticsService
import com.example.dagger2.UserRegistrationComponents
import dagger.Component
import dagger.Provides
import javax.inject.Singleton


@Singleton
@Component(modules = [AnalyticsModule::class])
interface AppComponent {

    fun getUserRegistrationComponentFactory() : UserRegistrationComponents.Factory
     /* You can directly return the Component when factory is not present
     * */
}