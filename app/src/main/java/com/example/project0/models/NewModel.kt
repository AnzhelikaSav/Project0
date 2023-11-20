package com.example.project0.models

data class NewModel(
    val id: Int = -1,
    val title: String = "",
    val description: String = "",
    val date: String = "",
    val keywords: ArrayList<String> = arrayListOf(),
    val visible: Boolean = false
)