package com.github.plnice.epoxyparistalk.main.view

import com.airbnb.epoxy.TypedEpoxyController
import com.github.plnice.epoxyparistalk.main.MainActivityMvp.ListItem
import io.reactivex.BackpressureStrategy.*
import io.reactivex.Flowable
import io.reactivex.subjects.PublishSubject

class MainActivityController : TypedEpoxyController<List<ListItem>>() {

    private val clicksSubject: PublishSubject<Int> = PublishSubject.create()

    override fun buildModels(data: List<ListItem>) {
        data.forEach {
            listItemCustomView {
                id(it.id)
                title(it.title)
                subtitle(it.subtitle)
                clickListener { _ -> clicksSubject.onNext(it.id) }
            }
        }
    }

    fun listItemClicks(): Flowable<Int> = clicksSubject.toFlowable(DROP)

}
