package com.github.plnice.epoxyparistalk.main.view

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.airbnb.paris.annotations.Attr
import com.airbnb.paris.annotations.Style
import com.airbnb.paris.annotations.Styleable
import com.github.plnice.epoxyparistalk.Paris
import com.github.plnice.epoxyparistalk.R
import kotlinx.android.synthetic.main.list_item_custom_view.view.*

@Styleable("ListItemParisCustomView")
@ModelView
class ListItemParisCustomView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    companion object {

        @Style
        val DEFAULT_STYLE = R.style.ListItemParisCustomView

        @Style
        val GREY_STYLE = R.style.ListItemParisCustomView_Grey

        @Style
        val DARK_GREY_STYLE = R.style.ListItemParisCustomView_DarkGrey

    }

    init {
        LayoutInflater.from(context).inflate(R.layout.list_item_custom_view, this, true)
        Paris.style(this).apply(attrs)
    }

    @TextProp
    @Attr(R.styleable.ListItemParisCustomView_title)
    fun setTitle(text: CharSequence?) {
        title.text = text
    }

    @TextProp
    @Attr(R.styleable.ListItemParisCustomView_subtitle)
    fun setSubtitle(text: CharSequence?) {
        subtitle.text = text
    }

    @CallbackProp
    fun setClickListener(listener: OnClickListener?) {
        setOnClickListener(listener)
    }

}
