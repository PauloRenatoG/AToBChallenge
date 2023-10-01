package com.example.atobchallenge.data.localdatasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.atobchallenge.data.model.ProductResponse

@Database(
    entities = [ProductResponse::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TypeConverterString::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        private const val DATABASE_NAME = "a-to-b-db"

        fun build(context: Context): AppDataBase {
            return Room.databaseBuilder(
                context,
                AppDataBase::class.java, DATABASE_NAME
            ).build()
        }
    }
}
