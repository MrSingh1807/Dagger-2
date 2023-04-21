package com.example.dagger2

import android.util.Log
import com.example.dagger2.Constants.Companion.TAG
import com.example.dagger2.CustomQualifiers.FirebaseQualifier
import javax.inject.Inject
import javax.inject.Named


class UserRegistrationService @Inject constructor(
    @FirebaseQualifier private val userRepository: UserRepository,
    @Named("Email") private val notificationService: NotificationService
) {

    fun registerUser(email: String, password: String){
        userRepository.saveUser(email, password)
        notificationService.send(email,"mrsingh@gmail.com",  "UserRegistered")
        Log.d(TAG, "mrsingh@gmail.com, UserRegistered")
    }
}