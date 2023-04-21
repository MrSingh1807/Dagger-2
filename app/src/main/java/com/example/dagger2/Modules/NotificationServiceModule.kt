package com.example.dagger2.Modules

import com.example.dagger2.CustomQualifiers.MessageQualifier
import com.example.dagger2.EmailService
import com.example.dagger2.MessageService
import com.example.dagger2.NotificationService
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class NotificationServiceModule {


    companion object{
        @MessageQualifier
        @Provides
        fun getMessageService(): NotificationService {
            return MessageService()
        }
    }

    @Named("Email")
    @Binds
    abstract fun getEmailService(emailService: EmailService): NotificationService
}