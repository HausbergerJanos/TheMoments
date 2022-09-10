package com.application.themoments.util.recyclerview.mvvm_recyclerview

import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

typealias ViewHolderFactory<VH> = (parent: ViewGroup, viewType: Int) -> VH
typealias ViewTypeFactory<IVM> = (itemViewModel: IVM) -> Int

open class MVVMListAdapter<ItemViewModel, ViewHolder : MVVMViewHolder<in ItemViewModel>>(
    diffCallback: DiffUtil.ItemCallback<ItemViewModel>,
    private val viewHolderFactory: ViewHolderFactory<ViewHolder>,
    private val viewTypeFactory: ViewTypeFactory<ItemViewModel>? = null,
    private val onItemBind: ((holder: ViewHolder, position: Int) -> Unit)? = null
) : ListAdapter<ItemViewModel, ViewHolder>(diffCallback), Observer<List<ItemViewModel>> {
    override fun getItemViewType(position: Int): Int =
        viewTypeFactory?.invoke(getItem(position)) ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        viewHolderFactory.invoke(parent, viewType)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.model = super.getItem(position)
        onItemBind?.invoke(holder, position)
    }

    override fun onChanged(t: List<ItemViewModel>?) {
        submitList(t)
    }
}