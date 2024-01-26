package com.alex.dashboarddemo.data.local

import androidx.room.TypeConverter
import com.alex.dashboarddemo.domain.entity.convert.GSDAConvertAttribute
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types.newParameterizedType
import javax.inject.Inject

class GSDADataBaseConvert @Inject constructor(
    private val moshiInit: Moshi,
) {
    @TypeConverter
    fun fromJson(json: String?): List<GSDAConvertAttribute?> {
        return if (json.isNullOrEmpty()) {
            emptyList()
        } else {
            val dataDashboard = moshiInit.adapter(Array<GSDAConvertAttribute>::class.java)
            return dataDashboard.fromJson(json)?.toList() ?: emptyList()
        }
    }

    @TypeConverter
    fun toJson(attributes: List<GSDAConvertAttribute>?): String {
        return if (attributes == null) {
            ""
        } else {
            val adapter = moshiInit.adapter<List<GSDAConvertAttribute>>(
                newParameterizedType(
                    List::class.java,
                    GSDAConvertAttribute::class.java,
                ),
            )
            adapter.toJson(attributes)
        }
    }
}
