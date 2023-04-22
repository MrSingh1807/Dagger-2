package com.example.dagger2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.dagger2.databinding.ActivityMainBinding
import com.example.dagger2.viewmodels.MainViewModel
import com.example.dagger2.viewmodels.MainViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.productsRemoteData.observe(this){
            binding.products.text = it.joinToString { product -> product.title + "\n\n" }

            mainViewModel.offlineSaveData(it)
        }
    }
}