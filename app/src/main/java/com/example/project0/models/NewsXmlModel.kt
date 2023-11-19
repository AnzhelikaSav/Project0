package com.example.project0.models

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "root", strict = false)
data class NewsXmlModel(
    @field:Element(name = "location") var location: String? = null,
    @field:Element(name = "name") var name: String? = null,
    @field:ElementList(name = "news", entry = "element") var news: ArrayList<NewXmlModel> = arrayListOf()
)

@Root(name = "element", strict = false)
data class NewXmlModel(
    @field:Element(name = "date") var date: String? = null,
    @field:Element(name = "description") var description: String? = null,
    @field:Element(name = "id") var id: Int? = null,
    @field:ElementList(name = "keywords", entry = "element") var keywords: ArrayList<String> = arrayListOf(),
    @field:Element(name = "title") var title: String? = null,
    @field:Element(name = "visible") var visible: String? = null
)