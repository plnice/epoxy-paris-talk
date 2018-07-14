package com.github.plnice.epoxyparistalk.main.presenter

import com.github.plnice.epoxyparistalk.main.MainActivityMvp.Data
import com.github.plnice.epoxyparistalk.main.MainActivityMvp.ListItem
import org.joda.time.format.DateTimeFormat
import javax.inject.Inject

class DataTransformer
@Inject constructor() {

    fun dataToListItems(data: Data): List<ListItem> {
        return data.items.map {
            ListItem(id = it.id, title = it.text, subtitle = it.date.toString(DateTimeFormat.fullDate()))
        }
    }

}
