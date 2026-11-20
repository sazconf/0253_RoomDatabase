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
