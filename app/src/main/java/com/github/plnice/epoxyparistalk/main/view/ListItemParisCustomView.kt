package com.github.plnice.epoxyparistalk.main.view

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.airbnb.paris.annotations.Style
import com.airbnb.paris.annotations.Styleable
import com.github.plnice.epoxyparistalk.Paris
import com.github.plnice.epoxyparistalk.R
import kotlinx.android.synthetic.main.list_item_custom_view.view.*

@Styleable
@ModelView
class ListItemParisCustomView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    companion object {
        @Style
        val DEFAULT_STYLE = R.style.ListItemParisCustomView
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.list_item_custom_view, this, true)
        Paris.style(this)
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
