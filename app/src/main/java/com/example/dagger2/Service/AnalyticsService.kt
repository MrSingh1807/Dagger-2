package com.example.dagger2.Service

import android.util.Log
import com.example.dagger2.Constants.Companion.TAG
import javax.inject.Inject


interface AnalyticsService {
    fun trackEvent(eventName: String, eventType: String)
}

class MixPanel @Inject constructor() : AnalyticsService {
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d(TAG,"MixPanel Service - $eventName, $eventType" )
    }
}

class FirebaseAnalytics: AnalyticsService {
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d(TAG,"FirebaseAnalytics Service - $eventName, $eventType" )
    }
}