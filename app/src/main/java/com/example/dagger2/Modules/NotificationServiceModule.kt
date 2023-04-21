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
class NotificationServiceModule {

    @MessageQualifier
    @Provides
    fun getMessageService(retryCount: Int): NotificationService {
        return MessageService(retryCount = retryCount)
    }

    @Named("Email")
    @Provides
    fun getEmailService(): NotificationService {
        return EmailService()
    }
}