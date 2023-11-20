package com.example.project0.models

import java.time.LocalDate

data class NewModel(
    val id: Int = -1,
    val title: String = "",
    val description: String = "",
    val date: LocalDate = LocalDate.now(),
    val keywords: ArrayList<String> = arrayListOf(),
    val visible: Boolean = false
)