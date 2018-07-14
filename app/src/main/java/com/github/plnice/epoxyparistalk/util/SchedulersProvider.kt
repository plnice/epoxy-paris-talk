package com.github.plnice.epoxyparistalk.util

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

interface SchedulersProvider {
    val main: Scheduler
    val computation: Scheduler
    val io: Scheduler
}

class DefaultSchedulersProvider
@Inject constructor() : SchedulersProvider {
    override val main: Scheduler = AndroidSchedulers.mainThread()
    override val computation: Scheduler = Schedulers.computation()
    override val io: Scheduler = Schedulers.io()
}

class TrampolineSchedulersProvider
@Inject constructor() : SchedulersProvider {
    override val main: Scheduler = Schedulers.trampoline()
    override val computation: Scheduler = Schedulers.trampoline()
    override val io: Scheduler = Schedulers.trampoline()
}
