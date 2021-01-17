package com.androidsystems.whoatapp.ui.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.androidsystems.whoatapp.ui.reports.ReportsAdapter.ItemViewHolder

abstract class HeaderFooterViewHolder : RecyclerView.Adapter<ViewHolder>() {

    val VIEW_TYPE_HEADER = 0
    val VIEW_TYPE_ITEM = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == VIEW_TYPE_HEADER) {
            return onCreateHeaderViewHolder(parent)
        }
        return onCreateItemViewHolder(parent)
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return VIEW_TYPE_HEADER
        }
        return VIEW_TYPE_ITEM
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    protected abstract fun onCreateHeaderViewHolder(parent: ViewGroup): ViewHolder
    protected abstract fun onCreateItemViewHolder(parent: ViewGroup): ViewHolder
    protected abstract fun onBindItemContent(itemViewHolder: ItemViewHolder, position: Int)
}