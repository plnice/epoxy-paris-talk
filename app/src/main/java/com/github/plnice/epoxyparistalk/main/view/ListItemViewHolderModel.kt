package com.github.plnice.epoxyparistalk.main.view

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyAttribute.Option.DoNotHash
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

    @EpoxyAttribute(DoNotHash)
    lateinit var clickListener: View.OnClickListener

    override fun bind(holder: ListItemHolder) {
        holder.bindTitle(title)
        holder.bindSubtitle(subtitle)
        holder.bindListener(clickListener)
    }

    override fun unbind(holder: ListItemHolder) {
        holder.unbindListener()
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

        fun bindListener(listener: View.OnClickListener?) {
            root.setOnClickListener(listener)
        }

        fun unbindListener() {
            root.setOnClickListener(null)
        }
    }
}
