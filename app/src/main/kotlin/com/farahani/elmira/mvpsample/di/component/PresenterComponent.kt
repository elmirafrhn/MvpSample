package com.farahani.elmira.mvpsample.di.component

import com.farahani.elmira.mvpsample.ui.album.AlbumsPresenter
import com.farahani.elmira.mvpsample.base.BaseView
import com.farahani.elmira.mvpsample.di.module.ContextModule
import com.farahani.elmira.mvpsample.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterComponent {

    fun inject(albumsPresenter: AlbumsPresenter)

    @Component.Builder
    interface Builder {

        fun build(): PresenterComponent
        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder
        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}