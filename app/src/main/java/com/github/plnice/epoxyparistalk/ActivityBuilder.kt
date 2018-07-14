package com.github.plnice.epoxyparistalk

import com.github.plnice.epoxyparistalk.main.MainActivity
import com.github.plnice.epoxyparistalk.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    @ActivityScope
    abstract fun bindMainActivity(): MainActivity

}
