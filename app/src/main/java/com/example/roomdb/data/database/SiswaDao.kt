package com.example.roomdb.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

private const val SELECT_ALL_SISWA = "SELECT * FROM siswa ORDER BY nama ASC"

@Dao
interface SiswaDao {
    @Query(SELECT_ALL_SISWA)
    fun getAllSiswa(): Flow<List<Siswa>>

    @Insert
    suspend fun insertSiswa(siswa: Siswa)
}
