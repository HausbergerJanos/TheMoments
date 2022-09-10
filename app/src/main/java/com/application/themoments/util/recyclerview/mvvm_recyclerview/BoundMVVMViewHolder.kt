package com.application.themoments.util.recyclerview.mvvm_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import com.application.themoments.BR
import kotlin.properties.Delegates

@Suppress("LongParameterList")
open class BoundMVVMViewHolder<T>(
    parent: ViewGroup,
    @LayoutRes layoutId: Int,
    bindingComponent: DataBindingComponent? = null,
    viewLifecycleOwner: LifecycleOwner? = null,
    val binding: ViewDataBinding = DataBindingUtil.inflate<ViewDataBinding>(
        LayoutInflater.from(parent.context), // todo ask Attila about it
        layoutId,
        parent,
        false,
        bindingComponent
    ).apply { lifecycleOwner = viewLifecycleOwner },
    onModelChange: (ViewDataBinding.(model: T) -> Unit)? = null,
    onItemClick: ((item: T, position: Int) -> Unit)? = null,
) : MVVMViewHolder<T>(binding.root) {

    override var model: T? by Delegates.observable(null) { _, _: T?, new: T? ->
        binding.setVariable(BR.model, new)
        if (onModelChange != null && new != null) onModelChange(binding, new)
        binding.executePendingBindings()
    }

    init {
        onItemClick?.let { listener ->
            itemView.setOnClickListener {
                model?.let { listener.invoke(it, absoluteAdapterPosition) }
            }
        }
    }
}