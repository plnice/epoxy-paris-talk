package com.github.plnice.epoxyparistalk.main.view

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.github.plnice.epoxyparistalk.R
import kotlinx.android.synthetic.main.list_item_custom_view.view.*

@ModelView(defaultLayout = R.layout.dl_list_item_custom_view)
class ListItemCustomView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.list_item_custom_view, this, true)
    }

    @TextProp
    fun setTitle(text: CharSequence?) {
        title.text = text
    }

    @TextProp
    fun setSubtitle(text: CharSequence?) {
        subtitle.text = text
    }

    @CallbackProp
    fun setClickListener(listener: OnClickListener?) {
        setOnClickListener(listener)
    }

}
