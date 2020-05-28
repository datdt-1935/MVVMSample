package com.sun.mvvmsample.ui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseRecyclerAdapter<T, VH : BaseViewHolder<T>>(
    itemCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, VH>(itemCallback) {

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bindData(getItem(position))
}
