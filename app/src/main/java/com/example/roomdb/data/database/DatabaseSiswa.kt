package com.example.roomdb.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Siswa::class], version = 1, exportSchema = false)
abstract class DatabaseSiswa : RoomDatabase() {
    abstract fun siswaDao(): SiswaDao

    companion object {
        @Volatile
        private var INSTANCE: DatabaseSiswa? = null
        private const val DATABASE_NAME = "siswa_database"

        fun getDatabase(context: Context): DatabaseSiswa =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseSiswa::class.java,
                    DATABASE_NAME
                ).build().also { INSTANCE = it }
            }
    }
}
