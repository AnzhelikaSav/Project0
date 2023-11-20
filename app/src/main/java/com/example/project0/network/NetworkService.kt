package com.example.project0.network

import com.example.project0.network.models.NewsJsonModel
import com.example.project0.network.models.NewsXmlModel

class NetworkService {
    private val newsApi = RetrofitHelper.getInstance().create(NewsApi::class.java)

    suspend fun getNewsJson(): NewsJsonModel {
        return newsApi.getNewsJson()
    }

    suspend fun getNewsXml(): NewsXmlModel {
        return newsApi.getNewsXml()
    }
}