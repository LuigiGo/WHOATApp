package com.androidsystems.whoatapp.data.entity


import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("CumCase")
    val cumCase: Int,
    @SerializedName("CumDeath")
    val cumDeath: Int,
    @SerializedName("OBJECTID")
    val oBJECTID: Int
)