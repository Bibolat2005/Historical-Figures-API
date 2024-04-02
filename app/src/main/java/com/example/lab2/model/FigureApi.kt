package com.example.lab2.model

import com.google.gson.annotations.SerializedName

data class FigureApi(
    val name: String,
    val title: String,
    val info: FigureInfo?
)


