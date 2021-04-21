package com.androidsystems.whoatapp.ui.reports.epoxy

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.androidsystems.whoatapp.R
import kotlinx.android.synthetic.main.view_item.view.*

@EpoxyModelClass(layout = R.layout.view_item)
abstract class FeatureModel : EpoxyModelWithHolder<FeatureModel.FeatureHolder>() {

    @EpoxyAttribute
    var confirmedCases: String? = ""

    @EpoxyAttribute
    var totalDeaths: String? = ""

    override fun bind(holder: FeatureHolder) {
        holder.tvConfirmedCases.text = confirmedCases
        holder.tvTotalDeaths.text = totalDeaths
    }

    inner class FeatureHolder : EpoxyHolder() {

        lateinit var tvConfirmedCases: TextView
        lateinit var tvTotalDeaths: TextView

        override fun bindView(itemView: View) {
            tvConfirmedCases = itemView.tv_confirmed_cases
            tvTotalDeaths = itemView.tv_total_deaths
        }

    }
}