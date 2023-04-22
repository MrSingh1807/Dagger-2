package com.example.dagger2.viewmodels

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel2 @Inject constructor(
    private val random: Random
) : ViewModel() {
    init {
        random.doAction()
    }
}

class Random @Inject constructor() {
    fun doAction(){}
}