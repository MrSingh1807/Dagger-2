package com.example.dagger2

import android.util.Log
import com.example.dagger2.Constants.Companion.TAG
import javax.inject.Inject


class EmailService @Inject constructor() {

    fun send(to: String, from: String, body: String?) {
        Log.d(TAG, "Email Sent")
    }
}