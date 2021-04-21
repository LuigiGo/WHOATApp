package com.androidsystems.whoatapp.ui.reports.epoxy

import android.util.Log
import com.airbnb.epoxy.EpoxyController
import com.androidsystems.whoatapp.data.entity.reports.Feature
import com.androidsystems.whoatapp.utilities.helpers.Conversions

class FeatureController(val conversions: Conversions) : EpoxyController() {

    var allFeatures: List<Feature> = emptyList()
        set(value) {
            field = value
            println(">>>Test: Setting up allFeatures")
            requestModelBuild()
        }

    override fun buildModels() {

        allFeatures.forEachIndexed { index, feature ->
            val attributes = feature.attributes
            Log.e(">>>Test: ", "buildModels: Setting up allFeatures item: ${allFeatures.size}")

            feature {
                id(index)
                confirmedCases(conversions.convertToDecimalFormat(attributes.cumCase.toString()))
                totalDeaths(conversions.convertToDecimalFormat(attributes.cumDeath.toString()))
            }
        }
    }
}