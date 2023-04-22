package com.example.dagger2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dagger2.databinding.FakeStoreAdapterBinding
import com.example.dagger2.models.Product


class FakeStoreAdapter(
    private val context : Context,
    private val products: List<Product>
) : RecyclerView.Adapter<FakeStoreAdapter.FakeStoreViewHolder>() {


    inner class FakeStoreViewHolder(val binding: FakeStoreAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FakeStoreViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val bind = FakeStoreAdapterBinding.inflate(layoutInflater, parent, false)
        return FakeStoreViewHolder(bind)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: FakeStoreViewHolder, position: Int) {
        val currentProduct = products[position]

        holder.binding.titleTV.text = currentProduct.title
        holder.binding.descriptionTV.text = currentProduct.description
        holder.binding.categoryTV.text = currentProduct.category
        holder.binding.priceTV.text = currentProduct.price.toString() + " $"

        Glide.with(context).load(currentProduct.image).into(holder.binding.imageIV)

    }
}