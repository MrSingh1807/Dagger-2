package com.example.dagger2

import android.util.Log
import com.example.dagger2.Constants.Companion.TAG
import com.example.dagger2.scopes.ActivityScope
import com.example.dagger2.scopes.ApplicationScope
import javax.inject.Inject


interface NotificationService{
    fun send(to: String, from: String, body: String?)
}

class EmailService : NotificationService  {
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email Sent")
    }
}

@ActivityScope
class MessageService (private val retryCount: Int) : NotificationService{
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Message Sent - Retry Count - $retryCount")
    }

}