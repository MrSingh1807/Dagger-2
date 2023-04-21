package com.example.dagger2

import com.example.dagger2.Modules.NotificationServiceModule
import com.example.dagger2.Modules.UserRepositoryModule
import com.example.dagger2.component.AppComponent
import com.example.dagger2.component.DaggerAppComponent.Builder
import com.example.dagger2.scopes.ActivityScope
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent


@ActivityScope
@Subcomponent( modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponents {
   fun inject(mainActivity: MainActivity)

   @Subcomponent.Builder
   interface Builder {

      fun build() : UserRegistrationComponents
      fun retryCount(@BindsInstance retryCount : Int ): Builder

   }
}