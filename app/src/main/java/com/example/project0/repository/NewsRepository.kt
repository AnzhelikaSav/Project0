package com.example.project0.repository

import com.example.project0.models.NewModel
import com.example.project0.network.NetworkService
import com.example.project0.network.models.NewsJsonModel
import com.example.project0.network.models.NewsXmlModel

class NewsRepository(private val networkService: NetworkService) {
    suspend fun getNewsJson(): List<NewModel> {
        val result = networkService.getNewsJson()
        return result.toNewsModel()
    }

    suspend fun getNewsXml(): List<NewModel> {
        val result = networkService.getNewsXml()
        return result.toNewsModel()
    }

    private fun NewsJsonModel.toNewsModel(): List<NewModel> {
        return this.news.map {
            NewModel(
                id = it.id ?: -1,
                title = it.title ?: "",
                description = it.description ?: "",
                date = it.date ?: "",
                keywords = it.keywords,
                visible = it.visible ?: false
            )
        }
    }

    private fun NewsXmlModel.toNewsModel(): List<NewModel> {
        return this.news.map {
            NewModel(
                id = it.id ?: -1,
                title = it.title ?: "",
                description = it.description ?: "",
                date = it.date ?: "",
                keywords = it.keywords,
                visible = it.visible ?: false
            )
        }
    }
}