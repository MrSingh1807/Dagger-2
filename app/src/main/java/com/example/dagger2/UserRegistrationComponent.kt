package com.example.dagger2

import dagger.Component


@Component
interface UserRegistrationComponents {

   fun inject(mainActivity: MainActivity)
}