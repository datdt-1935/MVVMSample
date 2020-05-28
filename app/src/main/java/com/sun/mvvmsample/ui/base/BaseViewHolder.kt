package com.sun.mvvmsample.ui.base

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(
    itemView: View,
    onItemClick: (T) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private var item: T? = null

    init {
        itemView.setOnClickListener {
            item?.let { onItemClick(it) }
        }
    }

    open fun bindData(item: T) {
        this.item = item
    }
}
