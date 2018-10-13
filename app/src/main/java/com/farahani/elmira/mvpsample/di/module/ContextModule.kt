package com.farahani.elmira.mvpsample.di.module

import android.app.Application
import android.content.Context
import com.farahani.elmira.mvpsample.base.BaseView
import dagger.Module
import dagger.Provides

@Module
object ContextModule {

    @Provides
    @JvmStatic
    internal fun provideContext(baseView: BaseView): Context = baseView.getContext()

    @Provides
    @JvmStatic
    internal fun provideApplication(context: Context): Application = context.applicationContext as Application
}