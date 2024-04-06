package com.example.lab2.network

//import FigureInfoDeserializer
import com.example.lab2.model.FigureInfo
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request()
            val newRequest = request.newBuilder()
                .addHeader("X-Api-Key", "expr29l2stE20oTVPDMlPQ==d3nPXtmSHRhkAz93")
                .build()
            chain.proceed(newRequest)
        }
        .build()

    private const val BASE_URL = "https://api.api-ninjas.com/"

    val instance: FigureService by lazy {


        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(FigureService::class.java)
    }
}