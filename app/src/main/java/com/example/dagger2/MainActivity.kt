package com.example.dagger2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger2.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding

    lateinit var userRegistrationComponents: UserRegistrationComponents

    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val appComponent = (application as UserApplication).appComponent
        userRegistrationComponents = appComponent.getUserRegistrationComponentBuilders()
            .retryCount(3).build()
        userRegistrationComponents.inject(this)

        userRegistrationService.registerUser("Mr Singh", "1111")

    }
}