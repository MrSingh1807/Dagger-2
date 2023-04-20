package com.example.dagger2

import android.util.Log
import com.example.dagger2.Constants.Companion.TAG
import javax.inject.Inject


class UserRegistrationService @Inject constructor(
    private val userRepository: UserRepository,
    private val emailService: EmailService
) {

    fun registerUser(email: String, password: String){
        userRepository.saveUser(email, password)
        emailService.send(email,"mrsingh@gmail.com",  "UserRegistered")
        Log.d(TAG, "mrsingh@gmail.com, UserRegistered")
    }
}