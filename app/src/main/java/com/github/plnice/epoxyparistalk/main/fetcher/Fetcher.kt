package com.github.plnice.epoxyparistalk.main.fetcher

import com.github.plnice.epoxyparistalk.main.MainActivityMvp
import com.github.plnice.epoxyparistalk.main.MainActivityMvp.*
import io.reactivex.Flowable
import org.joda.time.LocalDate
import javax.inject.Inject

class Fetcher
@Inject constructor() : MainActivityMvp.Fetcher {

    override fun getData(): Flowable<Data> {
        return Flowable.just(Data(listOf(
                DataItem(id = 0, date = LocalDate(2018, 7, 1), text = "Item 1"),
                DataItem(id = 1, date = LocalDate(2018, 7, 2), text = "Item 2"),
                DataItem(id = 2, date = LocalDate(2018, 7, 3), text = "Item 3")
        )))
    }

}
