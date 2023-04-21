package com.example.dagger2

import android.util.Log
import com.example.dagger2.Constants.Companion.TAG
import javax.inject.Inject


interface NotificationService{
    fun send(to: String, from: String, body: String?)
}

class EmailService @Inject constructor() : NotificationService  {
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email Sent")
    }
}

class MessageService : NotificationService{
    override fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Message Sent")
    }

}