package com.github.plnice.epoxyparistalk.main.view

import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.github.plnice.epoxyparistalk.R
import com.github.plnice.epoxyparistalk.main.MainActivity
import com.github.plnice.epoxyparistalk.main.MainActivityMvp
import com.github.plnice.epoxyparistalk.main.MainActivityMvp.ListItem
import io.reactivex.Flowable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivityView
@Inject constructor(private val activity: MainActivity) : MainActivityMvp.View {

    private lateinit var controller: MainActivityController

    override fun onCreate() = with(activity) {
        setContentView(R.layout.activity_main)
        controller = MainActivityController()
        recycler_view.setController(controller)
    }

    override fun setListItems(items: List<ListItem>) {
        controller.setData(items)
    }

    override fun showToast(message: String) {
        Toast.makeText(activity, message, LENGTH_SHORT).show()
    }

    override fun listItemClicks(): Flowable<Int> {
        return controller.listItemClicks()
    }

}
