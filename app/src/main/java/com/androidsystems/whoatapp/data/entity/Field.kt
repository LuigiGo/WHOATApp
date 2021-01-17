package com.androidsystems.whoatapp.data.entity


import com.google.gson.annotations.SerializedName

data class Field(
    val alias: String,
    val defaultValue: Any,
    val domain: Any,
    val name: String,
    val sqlType: String,
    val type: String
)