package com.example.lab2.model

import com.google.gson.annotations.SerializedName

data class FigureInfo(
    val born: String,
    val died: String,
    val spouses: List<String>?,
    val children: List<String>,
    val partners: String,
    val conflicts: List<String>,
    val occupation: List<String>,
    @SerializedName("notable_work") val notableWork: List<String>
)
