package com.farahani.elmira.mvpsample.di.module

import com.farahani.elmira.mvpsample.BuildConfig
import com.farahani.elmira.mvpsample.network.AlbumApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideAlbumApi(retrofit: Retrofit): AlbumApi = retrofit.create(AlbumApi::class.java)

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {

        return Retrofit.Builder()
                .baseUrl("${BuildConfig.BASE_URL}")
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }

}