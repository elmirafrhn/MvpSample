package com.farahani.elmira.mvpsample.ui.album

import android.support.annotation.StringRes
import com.farahani.elmira.mvpsample.base.BaseView
import com.farahani.elmira.mvpsample.model.Album

interface IAlbumsView : BaseView {

    fun updatePost(posts: List<Album>)
    fun showError(error: String)
    fun showErorr(@StringRes resId: Int) = this.showError(getContext().getString(resId))
    fun showLoading()
    fun hideLoading()

}