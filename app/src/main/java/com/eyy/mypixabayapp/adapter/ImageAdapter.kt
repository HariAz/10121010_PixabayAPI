package com.eyy.mypixabayapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eyy.mypixabayapp.databinding.ItemImageBinding
import com.eyy.mypixabayapp.model.ImageResult
import com.squareup.picasso.Picasso

class ImageAdapter(private val images: List<ImageResult>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = images[position]
        holder.bind(image)
    }

    override fun getItemCount(): Int = images.size

    class ImageViewHolder(private val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(image: ImageResult) {
            Picasso.get().load(image.previewURL).into(binding.imageView)
            binding.textViewTags.text = image.tags
        }
    }
}