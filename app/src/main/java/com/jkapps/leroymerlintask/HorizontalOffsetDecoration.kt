package com.jkapps.leroymerlintask

import android.graphics.Rect
import android.view.View
import androidx.annotation.Px
import androidx.recyclerview.widget.RecyclerView

class HorizontalOffsetDecoration(
    @Px private val start: Int,
    @Px private val end: Int,
    @Px private val between: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        val count = parent.adapter?.itemCount ?: return

        when (position) {
            0 -> {
                outRect.left = start
                outRect.right = between / 2
            }
            count - 1 -> {
                outRect.left = between / 2
                outRect.right = end
            }
            else -> {
                outRect.left = between / 2
                outRect.right = between / 2
            }
        }
    }
}