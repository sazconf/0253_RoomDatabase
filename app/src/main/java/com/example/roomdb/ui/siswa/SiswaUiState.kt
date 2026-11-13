package com.example.roomdb.ui.siswa

import com.example.roomdb.data.database.Siswa

data class SiswaUiState(
    val siswaEvent: SiswaEvent = SiswaEvent(),
    val isEntryValid: Boolean = false
)

data class SiswaEvent(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telepon: String = ""
)

data class HomeUiState(
    val listSiswa: List<Siswa> = emptyList()
)

fun SiswaEvent.toSiswa(): Siswa =
    Siswa(
        id = id,
        nama = nama.trim(),
        alamat = alamat.trim(),
        telepon = telepon.trim()
    )

fun Siswa.toSiswaEvent(): SiswaEvent = SiswaEvent(
    id = id,
    nama = nama,
    alamat = alamat,
    telepon = telepon
)
