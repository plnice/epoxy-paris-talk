package com.github.plnice.epoxyparistalk.main.view

import com.airbnb.epoxy.TypedEpoxyController
import com.github.plnice.epoxyparistalk.main.MainActivityMvp.ListItem
import io.reactivex.BackpressureStrategy.*
import io.reactivex.Flowable
import io.reactivex.subjects.PublishSubject

class MainActivityController : TypedEpoxyController<List<ListItem>>() {

    private val clicksSubject: PublishSubject<Int> = PublishSubject.create()

    override fun buildModels(data: List<ListItem>) {
        data.forEachIndexed { index, item ->
            listItemParisCustomView {
                id(item.id)
                title(item.title)
                subtitle(item.subtitle)
                clickListener { _ -> clicksSubject.onNext(item.id) }
                if (index % 2 == 0) withDarkGreyStyle() else withGreyStyle()
            }
        }
    }

    fun listItemClicks(): Flowable<Int> = clicksSubject.toFlowable(DROP)

}
