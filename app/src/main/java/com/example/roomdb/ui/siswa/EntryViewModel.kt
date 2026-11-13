package com.example.roomdb.ui.siswa

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
    private val _uiState = MutableStateFlow(SiswaUiState())
    val uiState: StateFlow<SiswaUiState> = _uiState.asStateFlow()

    fun updateUiState(siswaEvent: SiswaEvent) {
        _uiState.value = SiswaUiState(
            siswaEvent = siswaEvent,
            isEntryValid = validateInput(siswaEvent)
        )
    }

    fun saveSiswa() {
        val siswaEvent = _uiState.value.siswaEvent
        if (!validateInput(siswaEvent)) return
        viewModelScope.launch {
            repositoriSiswa.insertSiswa(siswaEvent.toSiswa())
        }
    }

    private fun validateInput(siswaEvent: SiswaEvent): Boolean =
        with(siswaEvent) {
            nama.isNotBlank() && alamat.isNotBlank() && telepon.isNotBlank()
        }
}
