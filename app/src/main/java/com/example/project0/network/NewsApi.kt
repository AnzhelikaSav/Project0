package com.example.project0.network

import com.example.project0.network.models.NewsJsonModel
import com.example.project0.network.models.NewsXmlModel
import retrofit2.Response
import retrofit2.http.GET

interface NewsApi {
    @GET("/static/it_news.json")
    @JsonAndXmlConverters.Json
    suspend fun getNewsJson(): NewsJsonModel

    @GET("/static/it_news.xml")
    @JsonAndXmlConverters.Xml
    suspend fun getNewsXml(): NewsXmlModel
}