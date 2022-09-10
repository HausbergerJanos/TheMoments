package com.application.themoments.util.recyclerview.mvvm_recyclerview

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

fun <ItemViewModel, ViewHolder : MVVMViewHolder<in ItemViewModel>> RecyclerView.setup(
    lifecycleScope: CoroutineScope,
    items: Flow<List<ItemViewModel>>,
    adapter: MVVMListAdapter<ItemViewModel, ViewHolder>,
    fixedSize: Boolean = false,
    layoutManager: RecyclerView.LayoutManager? = null
) {
    items
        .onEach(adapter::submitList)
        .launchIn(lifecycleScope)
    setup(adapter, fixedSize, layoutManager)
}

fun <ViewHolder : RecyclerView.ViewHolder> RecyclerView.setup(
    adapter: RecyclerView.Adapter<ViewHolder>,
    fixedSize: Boolean = false,
    layoutManager: RecyclerView.LayoutManager? = null
) {
    // use this setting to improve performance if you know that changes
    // in content do not change the layout size of the RecyclerView
    setHasFixedSize(fixedSize)
    this.layoutManager = layoutManager ?: LinearLayoutManager(context)
    this.adapter = adapter
}

fun RecyclerView.removeAllItemDecorators() {
    while (itemDecorationCount > 0) {
        removeItemDecorationAt(0)
    }
}