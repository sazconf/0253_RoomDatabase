package com.example.roomdb.ui.siswa

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.roomdb.R
import kotlinx.coroutines.flow.StateFlow

private val EntryPadding = 16.dp
private val EntryFieldSpacing = 12.dp

@Composable
fun HalamanEntry(
    siswaUiState: StateFlow<SiswaUiState>,
    onSiswaValueChange: (SiswaEvent) -> Unit,
    onSimpan: () -> Unit,
    onKembali: () -> Unit
) {
    val uiState by siswaUiState.collectAsState()
    Column(
        modifier = Modifier.padding(EntryPadding),
        verticalArrangement = Arrangement.spacedBy(EntryFieldSpacing)
    ) {
        OutlinedTextField(
            value = uiState.siswaEvent.nama,
            onValueChange = { onSiswaValueChange(uiState.siswaEvent.copy(nama = it)) },
            label = { Text(stringResource(R.string.nama)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        OutlinedTextField(
            value = uiState.siswaEvent.alamat,
            onValueChange = { onSiswaValueChange(uiState.siswaEvent.copy(alamat = it)) },
            label = { Text(stringResource(R.string.alamat)) },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = uiState.siswaEvent.telepon,
            onValueChange = { onSiswaValueChange(uiState.siswaEvent.copy(telepon = it)) },
            label = { Text(stringResource(R.string.telepon)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Button(
            onClick = onSimpan,
            enabled = uiState.isEntryValid,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.btn_simpan))
        }
        Button(
            onClick = onKembali,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.back))
        }
    }
}
