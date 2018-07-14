package com.github.plnice.epoxyparistalk

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class EpoxyParisTalkApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
                .apply { inject(this@EpoxyParisTalkApplication) }
    }

}
