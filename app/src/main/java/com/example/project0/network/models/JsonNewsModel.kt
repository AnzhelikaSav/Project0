package com.example.project0.network.models

import com.google.gson.annotations.SerializedName

data class NewsJsonModel(
    @SerializedName("name") var name: String? = null,
    @SerializedName("location") var location: String? = null,
    @SerializedName("news") var news: ArrayList<NewJsonModel> = arrayListOf()
)

data class NewJsonModel(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("date") var date: String? = null,
    @SerializedName("keywords") var keywords: ArrayList<String> = arrayListOf(),
    @SerializedName("visible") var visible: Boolean? = null
)