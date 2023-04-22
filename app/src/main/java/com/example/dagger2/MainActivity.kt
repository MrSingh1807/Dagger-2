package com.example.dagger2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.dagger2.databinding.ActivityMainBinding
import com.example.dagger2.viewmodels.MainViewModel
import com.example.dagger2.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val applicationComponent = (application as FakeStoreApplication).applicationComponent
        applicationComponent.inject(this)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        mainViewModel.productsRemoteData.observe(this){
            binding.products.text = it.joinToString { product -> product.title + "\n\n" }

            mainViewModel.offlineSaveData(it)
        }
    }
}