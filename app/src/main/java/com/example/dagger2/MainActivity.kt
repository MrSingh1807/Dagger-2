package com.example.dagger2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger2.adapter.FakeStoreAdapter
import com.example.dagger2.databinding.ActivityMainBinding
import com.example.dagger2.models.Product
import com.example.dagger2.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var mainViewModel: MainViewModel
    var products: ArrayList<Product> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.productsRemoteData.observe(this) {
            val adapter = FakeStoreAdapter(this@MainActivity, it)
            binding.productsRV.adapter = adapter
            binding.productsRV.layoutManager = LinearLayoutManager(this)

            mainViewModel.offlineSaveData(it)
        }
    }
}