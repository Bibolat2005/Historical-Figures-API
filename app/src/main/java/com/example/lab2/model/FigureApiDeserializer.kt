package com.example.lab2.model

import com.google.gson.*
import java.lang.reflect.Type

class FigureApiDeserializer : JsonDeserializer<FigureApi> {

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): FigureApi {
        val jsonObject = json?.asJsonObject

        val name = jsonObject?.getAsJsonPrimitive("name")?.asString ?: ""
        val title = jsonObject?.getAsJsonPrimitive("title")?.asString ?: ""
        val figureInfo = context?.deserialize<FigureInfo>(jsonObject?.getAsJsonObject("info"), FigureInfo::class.java)
            ?: FigureInfo("", "", null, emptyList(), "", emptyList(), emptyList(), emptyList())

        return FigureApi(name, title, figureInfo)
    }
}
