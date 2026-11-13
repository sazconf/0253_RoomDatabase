package com.example.roomdb.ui.siswa

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.roomdb.R
import com.example.roomdb.data.database.Siswa
import kotlinx.coroutines.flow.StateFlow

@Composable
fun HalamanHome(
    homeUiState: StateFlow<HomeUiState>,
    onTambahSiswa: () -> Unit
) {
    val uiState by homeUiState.collectAsState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onTambahSiswa) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.entry_siswa)
                )
            }
        }
    ) { innerPadding ->
        if (uiState.listSiswa.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.no_items),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        } else {
            DaftarSiswa(
                siswa = uiState.listSiswa,
                contentPadding = innerPadding
            )
        }
    }
}

@Composable
private fun DaftarSiswa(
    siswa: List<Siswa>,
    contentPadding: PaddingValues
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(siswa, key = { it.id }) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(item.nama, style = MaterialTheme.typography.titleMedium)
                    Text(item.alamat, style = MaterialTheme.typography.bodyMedium)
                    Text(item.telepon, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}
