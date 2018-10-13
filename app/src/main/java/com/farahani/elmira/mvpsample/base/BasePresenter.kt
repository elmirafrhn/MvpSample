package com.farahani.elmira.mvpsample.base

import com.farahani.elmira.mvpsample.AlbumsPresenter
import com.farahani.elmira.mvpsample.di.component.DaggerPresenterComponent
import com.farahani.elmira.mvpsample.di.component.PresenterComponent
import com.farahani.elmira.mvpsample.di.module.ContextModule
import com.farahani.elmira.mvpsample.di.module.NetworkModule

abstract class BasePresenter<out V : BaseView>(protected  val view : V){

    init{
        inject()
    }

    private val injector: PresenterComponent= DaggerPresenterComponent
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    open fun onViewCreated(){

    }

    open fun onViewDestroyed(){

    }

    private fun inject() {

        when(this){
            is AlbumsPresenter -> injector.inject(this)
        }
    }

}