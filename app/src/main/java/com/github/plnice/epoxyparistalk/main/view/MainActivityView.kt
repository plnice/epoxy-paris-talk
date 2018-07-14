package com.github.plnice.epoxyparistalk.main.view

import com.github.plnice.epoxyparistalk.R
import com.github.plnice.epoxyparistalk.main.MainActivity
import com.github.plnice.epoxyparistalk.main.MainActivityMvp
import com.github.plnice.epoxyparistalk.main.MainActivityMvp.ListItem
import io.reactivex.Flowable
import javax.inject.Inject

class MainActivityView
@Inject constructor(private val activity: MainActivity) : MainActivityMvp.View {

    override fun onCreate() = with(activity) {
        setContentView(R.layout.activity_main)
    }

    override fun setListItems(items: List<ListItem>) {
        TODO()
    }

    override fun showToast(message: String) {
        TODO()
    }

    override fun listItemClicks(): Flowable<Int> {
        return Flowable.empty() // TODO
    }

}
