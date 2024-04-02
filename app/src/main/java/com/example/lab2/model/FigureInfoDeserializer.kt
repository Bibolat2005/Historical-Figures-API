import com.example.lab2.model.FigureInfo
import com.google.gson.*
import java.lang.reflect.Type

class FigureInfoDeserializer : JsonDeserializer<FigureInfo> {
    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): FigureInfo {
        val jsonObject = json.asJsonObject
        return FigureInfo(
            born = jsonObject.getAsJsonPrimitive("born")?.asString ?: "",
            died = jsonObject.getAsJsonPrimitive("died")?.asString ?: "",
            spouses = if (jsonObject.has("spouses")) {
                val spousesElement = jsonObject.get("spouses")
                if (spousesElement.isJsonArray) {
                    val spousesArray = spousesElement.asJsonArray
                    val spousesList = mutableListOf<String>()
                    spousesArray.forEach { spouse -> spousesList.add(spouse.asString) }
                    spousesList
                } else {
                    emptyList()
                }
            } else {
                emptyList()
            },
            children = if (jsonObject.has("children")) {
                val childrenElement = jsonObject.get("children")
                if (childrenElement.isJsonArray) {
                    val childrenArray = childrenElement.asJsonArray
                    val childrenList = mutableListOf<String>()
                    childrenArray.forEach { child -> childrenList.add(child.asString) }
                    childrenList
                } else {
                    emptyList()
                }
            } else {
                emptyList()
            },
            partners = jsonObject.getAsJsonPrimitive("partners")?.asString ?: "",
            conflicts = if (jsonObject.has("conflicts")) {
                val conflictsElement = jsonObject.getAsJsonArray("conflicts")
                val conflictsList = mutableListOf<String>()
                conflictsElement.forEach { conflict -> conflictsList.add(conflict.asString) }
                conflictsList.toList()
            } else {
                emptyList()
            },
            occupation = if (jsonObject.has("occupation")) {
                val occupationElement = jsonObject.getAsJsonArray("occupation")
                val occupationList = mutableListOf<String>()
                occupationElement.forEach { occupation -> occupationList.add(occupation.asString) }
                occupationList.toList()
            } else {
                emptyList()
            },
            notableWork = if (jsonObject.has("notable_work")) {
                val notableWorkElement = jsonObject.getAsJsonArray("notable_work")
                val notableWorkList = mutableListOf<String>()
                notableWorkElement.forEach { notableWork -> notableWorkList.add(notableWork.asString) }
                notableWorkList.toList()
            } else {
                emptyList()
            }
        )
    }
}
