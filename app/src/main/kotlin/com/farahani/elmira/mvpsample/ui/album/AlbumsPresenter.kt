package com.farahani.elmira.mvpsample.ui.album

import com.farahani.elmira.mvpsample.base.BasePresenter
import com.farahani.elmira.mvpsample.network.AlbumApi
import com.farahani.elmira.mvpsample.ui.album.IAlbumsView
import com.farahani.elmira.myapplication.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AlbumsPresenter(albumView: IAlbumsView) : BasePresenter<IAlbumsView>(albumView) {
    @Inject
    lateinit var albumApi: AlbumApi
    private var disposable: Disposable? = null

    override fun onViewCreated() {
        loadAlbums()
    }

    private fun loadAlbums() {
        view.showLoading()
        disposable = albumApi.getAlbums()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { view.hideLoading() }
            .subscribe(
                { albumsList -> view.updateAlbums(albumsList) },
                { view.showErorr(R.string.unknown_error) }
            )
    }

    override fun onViewDestroyed() {
        disposable?.dispose()
    }
}