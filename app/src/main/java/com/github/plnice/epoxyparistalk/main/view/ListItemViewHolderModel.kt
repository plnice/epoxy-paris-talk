package com.github.plnice.epoxyparistalk.main.view

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.github.plnice.epoxyparistalk.R
import com.github.plnice.epoxyparistalk.main.view.ListItemViewHolderModel.ListItemHolder
import kotlinx.android.synthetic.main.list_item_view_holder.view.*

@EpoxyModelClass(layout = R.layout.list_item_view_holder)
abstract class ListItemViewHolderModel : EpoxyModelWithHolder<ListItemHolder>() {

    @EpoxyAttribute
    lateinit var title: String

    @EpoxyAttribute
    lateinit var subtitle: String

    override fun bind(holder: ListItemHolder) {
        holder.bindTitle(title)
        holder.bindSubtitle(subtitle)
    }

    class ListItemHolder : EpoxyHolder() {

        private lateinit var root: View

        override fun bindView(itemView: View) {
            root = itemView
        }

        fun bindTitle(title: String) {
            root.title.text = title
        }

        fun bindSubtitle(subtitle: String) {
            root.subtitle.text = subtitle
        }
    }
}
