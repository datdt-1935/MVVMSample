package com.sun.mvvmsample.ui.component

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class ItemSpaceDecoration(
    private val leftInset: Int = 0,
    private val topInset: Int = 0,
    private val rightInset: Int = 0,
    private val bottomInset: Int = 0
) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.apply {
            left = leftInset
            right = rightInset
            bottom = bottomInset
        }

        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = topInset
        }
    }
}
