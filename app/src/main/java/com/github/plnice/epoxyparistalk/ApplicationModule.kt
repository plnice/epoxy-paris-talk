package com.github.plnice.epoxyparistalk

import android.app.Application
import android.content.Context
import com.github.plnice.epoxyparistalk.util.DefaultSchedulersProvider
import com.github.plnice.epoxyparistalk.util.SchedulersProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun provideContext(application: Application): Context

    @Binds
    abstract fun provideSchedulersProvider(defaultSchedulersProvider: DefaultSchedulersProvider): SchedulersProvider

}
