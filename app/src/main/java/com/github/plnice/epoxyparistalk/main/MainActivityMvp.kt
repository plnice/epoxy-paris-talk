package com.github.plnice.epoxyparistalk.main

import io.reactivex.Flowable
import org.joda.time.LocalDate

interface MainActivityMvp {

    data class DataItem(val id: Int, val date: LocalDate, val text: String)
    data class Data(val items: List<DataItem>)

    data class ListItem(val id: Int, val title: String, val subtitle: String)

    interface Fetcher {
        fun getData(): Flowable<Data>
    }

    interface Presenter {
        fun start()
        fun stop()
    }

    interface View {
        fun onCreate()

        fun setListItems(items: List<ListItem>)
        fun showToast(message: String)

        fun listItemClicks(): Flowable<Int>
    }

}
