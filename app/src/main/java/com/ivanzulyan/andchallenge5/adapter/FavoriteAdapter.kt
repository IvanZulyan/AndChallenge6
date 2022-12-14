package com.ivanzulyan.andchallenge5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ivanzulyan.andchallenge5.databinding.ItemFavoriteBinding
import com.ivanzulyan.andchallenge5.model.FavoriteEntity

class FavoriteAdapter(var listMovie: List<FavoriteEntity>): RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemFavoriteBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTitle.text = listMovie[position].originalTitle
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500"+listMovie[position].posterPath)
            .into(holder.binding.imgPoster)
        holder.binding.tvVote.text = listMovie[position].voteAverage.toString()
    }

    override fun getItemCount(): Int = listMovie.size
}