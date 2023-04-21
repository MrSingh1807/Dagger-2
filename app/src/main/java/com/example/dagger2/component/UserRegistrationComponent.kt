package com.example.dagger2

import com.example.dagger2.Modules.NotificationServiceModule
import com.example.dagger2.Modules.UserRepositoryModule
import com.example.dagger2.scopes.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@ApplicationScope
@Component(modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponents {
   fun inject(mainActivity: MainActivity)

   @Component.Factory
   interface Factory {
      fun create(@BindsInstance retryCount : Int) : UserRegistrationComponents
   }
}