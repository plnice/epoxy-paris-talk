package com.github.plnice.epoxyparistalk.main.view

import com.airbnb.epoxy.TypedEpoxyController
import com.github.plnice.epoxyparistalk.main.MainActivityMvp.ListItem

class MainActivityController : TypedEpoxyController<List<ListItem>>() {

    override fun buildModels(data: List<ListItem>) {
        data.forEach {
            listItemViewHolder {
                id(it.id)
                title(it.title)
                subtitle(it.subtitle)
            }
        }
    }

}
