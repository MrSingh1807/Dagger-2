package com.example.dagger2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger2.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var binding :ActivityMainBinding

    @Inject
    lateinit var userRegistrationService: UserRegistrationService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val component = DaggerUserRegistrationComponents.factory().create(3)
        component.inject(this)

        userRegistrationService.registerUser("Mr Singh", "1111")

    }
}