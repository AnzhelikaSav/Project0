package com.example.project0.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object RetrofitHelper {
    private const val baseUrl = "https://api2.kiparo.com/"

    private val logging = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                JsonAndXmlConverters.QualifiedTypeConverterFactory(
                    GsonConverterFactory.create(), SimpleXmlConverterFactory.create()
                )
            )
            .client(client)
            .build()
    }
}