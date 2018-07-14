package com.github.plnice.epoxyparistalk

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun provideContext(application: Application): Context

}
