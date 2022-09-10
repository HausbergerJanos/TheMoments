package com.application.themoments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.themoments.databinding.FragmentFeedBinding
import com.application.themoments.feature.feed.FeedViewModel
import com.application.themoments.util.recyclerview.decoration.MarginItemDecoration
import com.application.themoments.util.recyclerview.diff_callback.DiffCallback
import com.application.themoments.util.recyclerview.mvvm_recyclerview.BoundMVVMViewHolder
import com.application.themoments.util.recyclerview.mvvm_recyclerview.MVVMListAdapter
import com.application.themoments.util.recyclerview.mvvm_recyclerview.setup
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : Fragment() {

    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FeedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        binding.apply {
            lifecycleOwner = this@FeedFragment
            model = viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.feedRecyclerView.setupFeedItems()
        binding.feedRecyclerView.addMarginItemDecoration()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun RecyclerView.setupFeedItems() {
        setup(
            lifecycleScope = viewLifecycleOwner.lifecycleScope,
            items = viewModel.test,
            adapter = MVVMListAdapter(
                diffCallback = DiffCallback(),
                viewHolderFactory = { parent, _ ->
                    BoundMVVMViewHolder(
                        parent = parent,
                        layoutId = R.layout.view_feed_item,
                        onModelChange = { model ->

                        }
                    )
                }
            )
        )
    }

    private fun RecyclerView.addMarginItemDecoration() {
        addItemDecoration(
            MarginItemDecoration(
                betweenItems = 16
            )
        )
    }
}