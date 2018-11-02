package com.farahani.elmira.mvpsample.ui.album

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.farahani.elmira.mvpsample.base.BaseActivity
import com.farahani.elmira.mvpsample.model.Album
import com.farahani.elmira.myapplication.R
import com.farahani.elmira.myapplication.databinding.ActivityMainBinding

class AlbumsActivity : BaseActivity<AlbumsPresenter>(), IAlbumsView {
    private lateinit var binding: ActivityMainBinding
    private val adapter = AlbumAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.adapter = adapter
        binding.layoutManager = LinearLayoutManager(this)
        binding.dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)

        presenter.onViewCreated()
    }

    override fun instantiatePresenter(): AlbumsPresenter {
        return AlbumsPresenter(this)
    }

    override fun updateAlbums(albums: List<Album>) {
        adapter.updateAlbums(albums)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }


}
