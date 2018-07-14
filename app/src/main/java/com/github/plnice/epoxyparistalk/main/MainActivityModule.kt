package com.github.plnice.epoxyparistalk.main

import android.support.v4.app.FragmentActivity
import com.github.plnice.epoxyparistalk.main.MainActivityModule.MainActivityProvidesModule
import dagger.Binds
import dagger.Module

@Module(includes = [MainActivityProvidesModule::class])
abstract class MainActivityModule {

    @Binds
    abstract fun provideFragmentActivity(mainActivity: MainActivity): FragmentActivity

    @Module
    class MainActivityProvidesModule

}
