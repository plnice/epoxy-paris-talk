package com.github.plnice.epoxyparistalk.main.presenter

import com.github.plnice.epoxyparistalk.main.MainActivityMvp
import com.github.plnice.epoxyparistalk.util.SchedulersProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import javax.inject.Inject

class MainActivityPresenter
@Inject constructor(private val fetcher: MainActivityMvp.Fetcher,
                    private val view: MainActivityMvp.View,
                    private val transformer: DataTransformer,
                    private val schedulersProvider: SchedulersProvider) : MainActivityMvp.Presenter {

    private val subscription = CompositeDisposable()

    override fun start() {

        subscription += fetcher
                .getData()
                .distinctUntilChanged()
                .map { transformer.dataToListItems(it) }
                .observeOn(schedulersProvider.main)
                .subscribe {
                    view.setListItems(it)
                }

        subscription += view
                .listItemClicks()
                .subscribe {
                    view.showToast("$it")
                }
    }

    override fun stop() {
        subscription.clear()
    }
}
