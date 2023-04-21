package com.example.dagger2

import com.example.dagger2.Modules.NotificationServiceModule
import com.example.dagger2.Modules.UserRepositoryModule
import com.example.dagger2.component.AppComponent
import com.example.dagger2.scopes.ActivityScope
import dagger.BindsInstance
import dagger.Component


@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponents {
   fun inject(mainActivity: MainActivity)

   @Component.Factory
   interface Factory {
      fun create(@BindsInstance retryCount : Int, appComponent: AppComponent) : UserRegistrationComponents
   }
}