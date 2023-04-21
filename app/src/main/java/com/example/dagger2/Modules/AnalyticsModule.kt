package com.example.dagger2.Modules

import com.example.dagger2.Service.AnalyticsService
import com.example.dagger2.Service.MixPanel
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
abstract class AnalyticsModule {

    @Singleton
    @Binds
    abstract fun getMixPanel(mixPanel: MixPanel) : AnalyticsService
}