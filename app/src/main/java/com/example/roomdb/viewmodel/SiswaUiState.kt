package com.example.roomdb.viewmodel

import com.example.roomdb.data.database.Siswa

data class UiStateSiswa(
    val detailSiswa: DetailSiswa = DetailSiswa(),
    val isEntryValid: Boolean = false
)

data class DetailSiswa(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telepon: String = "",
)

data class HomeUiState(
    val listSiswa: List<Siswa> = emptyList()
)

data class ItemDetailsUiState(
    val isOutofStock: Boolean = true,
    val detailSiswa: DetailSiswa = DetailSiswa()
)

fun DetailSiswa.toSiswa(): Siswa =
    Siswa(
        id = id,
        nama = nama.trim(),
        alamat = alamat.trim(),
        telepon = telepon.trim()
    )

fun Siswa.toUiStateSiswa(isEntryValid: Boolean = false): UiStateSiswa = UiStateSiswa(
    detailSiswa = this.toDetailSiswa(),
    isEntryValid = isEntryValid
)

fun Siswa.toDetailSiswa(): DetailSiswa = DetailSiswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telepon = telepon,
)
