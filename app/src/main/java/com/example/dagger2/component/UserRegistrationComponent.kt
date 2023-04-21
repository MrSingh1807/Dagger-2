package com.example.dagger2

import com.example.dagger2.Modules.NotificationServiceModule
import com.example.dagger2.Modules.UserRepositoryModule
import dagger.Component


@Component(modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponents {
   fun inject(mainActivity: MainActivity)

}