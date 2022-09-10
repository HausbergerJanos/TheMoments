package com.application.themoments.util.recyclerview.diff_callback

import androidx.recyclerview.widget.DiffUtil
import com.application.themoments.model.Identifiable

class DiffCallback<T : Identifiable> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.equals(newItem)
    }
}
