package com.farahani.elmira.mvpsample

import com.farahani.elmira.mvpsample.base.BasePresenter
import com.farahani.elmira.mvpsample.network.AlbumApi
import com.farahani.elmira.mvpsample.ui.album.AlbumView
import com.farahani.elmira.mvpsample.ui.album.IAlbumsView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class AlbumsPresenter(albumView: AlbumView) : BasePresenter<AlbumView>(albumView) {

    lateinit var iAlbumsView: IAlbumsView
    @Inject
    lateinit var albumApi: AlbumApi
    private var disposable: Disposable? = null

    override fun onViewCreated() {
        loadAlbums()
    }

    override fun onViewDestroyed() {
        super.onViewDestroyed()
    }

    private fun loadAlbums() {
        view.showLoading()
//        disposable= albumApi.getAlbums()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn()
//                .
    }

}