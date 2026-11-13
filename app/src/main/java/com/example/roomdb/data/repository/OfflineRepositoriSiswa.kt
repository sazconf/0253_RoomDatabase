package com.example.roomdb.data.repository

import com.example.roomdb.data.database.Siswa
import com.example.roomdb.data.database.SiswaDao
import kotlinx.coroutines.flow.Flow

class OfflineRepositoriSiswa(
    private val siswaDao: SiswaDao
) : RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> =
        siswaDao.getAllSiswa()

    override suspend fun insertSiswa(siswa: Siswa) =
        siswaDao.insertSiswa(siswa)
}
