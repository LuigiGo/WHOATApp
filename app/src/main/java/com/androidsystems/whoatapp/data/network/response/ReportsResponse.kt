package com.androidsystems.whoatapp.data.network.response

import com.androidsystems.whoatapp.data.entity.Feature
import com.androidsystems.whoatapp.data.entity.Field
import com.androidsystems.whoatapp.data.entity.SpatialReference
import com.androidsystems.whoatapp.data.entity.UniqueIdField

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