package com.github.plnice.epoxyparistalk.main

import android.support.v4.app.FragmentActivity
import com.github.plnice.epoxyparistalk.ActivityScope
import com.github.plnice.epoxyparistalk.main.MainActivityModule.MainActivityProvidesModule
import com.github.plnice.epoxyparistalk.main.fetcher.Fetcher
import com.github.plnice.epoxyparistalk.main.presenter.MainActivityPresenter
import com.github.plnice.epoxyparistalk.main.view.MainActivityView
import dagger.Binds
import dagger.Module

@Module(includes = [MainActivityProvidesModule::class])
abstract class MainActivityModule {

    @Binds
    abstract fun provideFragmentActivity(mainActivity: MainActivity): FragmentActivity

    @Binds
    @ActivityScope
    abstract fun provideFetcher(fetcher: Fetcher): MainActivityMvp.Fetcher

    @Binds
    @ActivityScope
    abstract fun providePresenter(presenter: MainActivityPresenter): MainActivityMvp.Presenter

    @Binds
    @ActivityScope
    abstract fun provideView(view: MainActivityView): MainActivityMvp.View

    @Module
    class MainActivityProvidesModule

}
