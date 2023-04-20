package com.example.dagger2

import dagger.Component


@Component
interface UserRegistrationComponents {

    fun getUserRegistrationService(): UserRegistrationService

    fun getEmailService() : EmailService
}