package com.example.roomdb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdb.data.repository.RepositoriSiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EntryViewModel(
    private val repositoriSiswa: RepositoriSiswa
) : ViewModel() {
    private val _uiState = MutableStateFlow(UiStateSiswa())
    val uiState: StateFlow<UiStateSiswa> = _uiState.asStateFlow()

    fun updateUiState(detailSiswa: DetailSiswa) {
        _uiState.value = UiStateSiswa(
            detailSiswa = detailSiswa,
            isEntryValid = validateInput(detailSiswa)
        )
    }

    fun saveSiswa() {
        val detailSiswa = _uiState.value.detailSiswa
        if (!validateInput(detailSiswa)) return
        viewModelScope.launch {
            repositoriSiswa.insertSiswa(detailSiswa.toSiswa())
        }
    }

    private fun validateInput(detailSiswa: DetailSiswa): Boolean =
        with(detailSiswa) {
            nama.isNotBlank() && alamat.isNotBlank() && telepon.isNotBlank()
        }
}

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
    val listSiswa: List<com.example.roomdb.data.database.Siswa> = emptyList()
)

fun DetailSiswa.toSiswa(): com.example.roomdb.data.database.Siswa =
    com.example.roomdb.data.database.Siswa(
        id = id,
        nama = nama.trim(),
        alamat = alamat.trim(),
        telepon = telepon.trim()
    )

fun com.example.roomdb.data.database.Siswa.toUiStateSiswa(isEntryValid: Boolean = false): UiStateSiswa = UiStateSiswa(
    detailSiswa = this.toDetailSiswa(),
    isEntryValid = isEntryValid
)

fun com.example.roomdb.data.database.Siswa.toDetailSiswa(): DetailSiswa = DetailSiswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telepon = telepon,
)
