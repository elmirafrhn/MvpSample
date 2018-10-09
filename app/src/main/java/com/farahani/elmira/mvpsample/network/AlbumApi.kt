package com.farahani.elmira.mvpsample.network

import com.farahani.elmira.mvpsample.model.Album
import io.reactivex.Observable
import retrofit2.http.GET


interface AlbumApi {

    @GET("/albums")
    fun getAlbums(): Observable<List<Album>>
}