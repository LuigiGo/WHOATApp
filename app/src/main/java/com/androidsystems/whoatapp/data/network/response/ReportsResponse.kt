package com.androidsystems.whoatapp.data.network.response

import com.androidsystems.whoatapp.data.entity.reports.Feature
import com.androidsystems.whoatapp.data.entity.reports.Field
import com.androidsystems.whoatapp.data.entity.reports.SpatialReference
import com.androidsystems.whoatapp.data.entity.reports.UniqueIdField

data class ReportsResponse(
    val exceededTransferLimit: Boolean,
    val features: List<Feature>,
    val fields: List<Field>,
    val geometryType: String,
    val globalIdFieldName: String,
    val objectIdFieldName: String,
    val spatialReference: SpatialReference,
    val uniqueIdField: UniqueIdField
)