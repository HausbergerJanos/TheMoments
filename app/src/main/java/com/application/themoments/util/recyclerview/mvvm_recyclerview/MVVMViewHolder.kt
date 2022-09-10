package com.application.themoments.util.recyclerview.mvvm_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class MVVMViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    constructor(@LayoutRes layoutRes: Int, parent: ViewGroup) : this(
        LayoutInflater.from(parent.context)
            .inflate(layoutRes, parent, false)
    )

    abstract var model: T?
}