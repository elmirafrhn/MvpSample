package com.farahani.elmira.mvpsample.ui.album

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.farahani.elmira.mvpsample.model.Album
import com.farahani.elmira.myapplication.R
import com.farahani.elmira.myapplication.databinding.AlbumItemBinding

private var albums: List<Album> = listOf()

class AlbumAdapter(private val context: Context) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumAdapter.AlbumViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: AlbumItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.album_item, parent, false)
        return AlbumViewHolder(binding)
    }
    fun updateAlbums(albumsList : List<Album>){
        albums=albumsList
        notifyDataSetChanged()

    }

    override fun onBindViewHolder(viewHolder: AlbumAdapter.AlbumViewHolder, position: Int) {
        viewHolder?.bind(albums.get(position))
    }

    override fun getItemCount()= albums.size
    class AlbumViewHolder(private val binding: AlbumItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(album: Album) {
            binding.album = album
            binding.executePendingBindings()
        }
    }

}