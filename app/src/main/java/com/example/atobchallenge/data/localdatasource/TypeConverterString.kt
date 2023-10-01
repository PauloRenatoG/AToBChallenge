package com.example.atobchallenge.data.localdatasource

import androidx.room.TypeConverter
import com.google.gson.Gson

class TypeConverterString {

    private val gson: Gson = Gson()

    @TypeConverter
    fun imageListToString(data: List<String>): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToImageList(data: String): List<String> {
        return gson.fromJson(data, Array<String>::class.java).asList()
    }
}