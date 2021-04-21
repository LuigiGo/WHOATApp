package com.androidsystems.whoatapp.ui.reports

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.androidsystems.whoatapp.R
import com.androidsystems.whoatapp.data.entity.reports.Feature
import com.androidsystems.whoatapp.ui.base.HeaderFooterViewHolder
import com.androidsystems.whoatapp.utilities.helpers.Conversions
import com.bumptech.glide.Glide

class ReportsAdapter(private val context: Context, private val conversions: Conversions) : HeaderFooterViewHolder() {

    private var reportsData: List<Feature> = ArrayList()

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgBackground: ImageView = itemView.findViewById(R.id.img_background)

        init {
            Glide.with(itemView.context).load(R.drawable.img_card_pilot_1).into(imgBackground)
        }
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgBackground: ImageView = itemView.findViewById(R.id.img_background)
        val tvConfirmedCases: TextView = itemView.findViewById(R.id.tv_confirmed_cases)
        val tvTotalDeaths: TextView = itemView.findViewById(R.id.tv_total_deaths)

        init {
            Glide.with(itemView.context).load(R.drawable.img_card_pilot_2).into(imgBackground)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == VIEW_TYPE_HEADER) {
            return onCreateHeaderViewHolder(parent)
        }
        return onCreateItemViewHolder(parent)
    }

    override fun onCreateHeaderViewHolder(parent: ViewGroup): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.view_header, parent, false)
        return HeaderViewHolder(v)
    }

    override fun onCreateItemViewHolder(parent: ViewGroup): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.view_item, parent, false)
        return ItemViewHolder(v)
    }

    override fun onBindItemContent(itemViewHolder: ItemViewHolder, position: Int) {
        val attributes = reportsData[position - 1].attributes
        val confirmedCases = conversions.convertToDecimalFormat(attributes.cumCase.toString())
        val confirmedTotalDeaths = conversions.convertToDecimalFormat(attributes.cumDeath.toString())

        itemViewHolder.tvConfirmedCases.text = confirmedCases
        itemViewHolder.tvTotalDeaths.text =
            String.format("%s %s", "$confirmedTotalDeaths ", context.getString(R.string.total_deaths))
    }

    fun setData(reportsData: List<Feature>) {
        this.reportsData = reportsData
    }

    override fun getItemCount(): Int {
        return reportsData.size + 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            onBindItemContent(holder, position)
        }
    }
}