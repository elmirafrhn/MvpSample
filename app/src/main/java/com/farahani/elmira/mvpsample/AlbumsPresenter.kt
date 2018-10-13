package com.farahani.elmira.mvpsample

import com.farahani.elmira.mvpsample.base.BasePresenter
import com.farahani.elmira.mvpsample.ui.album.AlbumView
import com.farahani.elmira.mvpsample.ui.album.IAlbumsView

class AlbumsPresenter(albumView: AlbumView) : BasePresenter<AlbumView>(albumView) {

    lateinit var iAlbumsView: IAlbumsView

    override fun onViewCreated() {
        super.onViewCreated()
    }

    override fun onViewDestroyed() {
        super.onViewDestroyed()
    }
}