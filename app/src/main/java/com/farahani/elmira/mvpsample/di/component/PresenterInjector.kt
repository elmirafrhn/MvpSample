package com.farahani.elmira.mvpsample.di.component

import com.farahani.elmira.mvpsample.AlbumsPresenter
import com.farahani.elmira.mvpsample.di.module.ContextModule
import com.farahani.elmira.mvpsample.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class),(NetworkModule::class)])
interface PresenterInjector {

    fun inject(albumsPresenter: AlbumsPresenter)


}