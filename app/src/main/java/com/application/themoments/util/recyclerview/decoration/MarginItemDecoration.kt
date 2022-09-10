package com.application.themoments.util.recyclerview.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.xeropan.student.util.misc.dpTopx

class MarginItemDecoration(
    val betweenItems: Int? = null,
    val orientation: Int = VERTICAL
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {
            when {
                parent.getChildAdapterPosition(view) != 0 && orientation == VERTICAL -> top = betweenItems?.dpTopx ?: top
                parent.getChildAdapterPosition(view) != 0 -> left = betweenItems?.dpTopx ?: left
            }
        }
    }
}