package com.example.lab2.network

import com.example.lab2.model.FigureApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FigureService {
    @GET("v1/historicalfigures")
    fun getFigures(@Query("name") name: String): Call<List<FigureApi>>
}