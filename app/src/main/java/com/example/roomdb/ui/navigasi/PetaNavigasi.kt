package com.example.roomdb.ui.navigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.roomdb.ui.PenyediaViewModel
import com.example.roomdb.ui.siswa.EntryViewModel
import com.example.roomdb.ui.siswa.HomeViewModel
import com.example.roomdb.ui.siswa.HalamanEntry
import com.example.roomdb.ui.siswa.HalamanHome
import com.example.roomdb.AplikasiSiswa

@Composable
fun PetaNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            val application = LocalContext.current.applicationContext as AplikasiSiswa
            val homeViewModel: HomeViewModel = viewModel(
                factory = PenyediaViewModel.Factory(application)
            )
            HalamanHome(
                homeUiState = homeViewModel.homeUiState,
                onTambahSiswa = { navController.navigate(DestinasiEntry.route) }
            )
        }
        composable(DestinasiEntry.route) {
            val application = LocalContext.current.applicationContext as AplikasiSiswa
            val entryViewModel: EntryViewModel = viewModel(
                factory = PenyediaViewModel.Factory(application)
            )
            HalamanEntry(
                siswaUiState = entryViewModel.uiState,
                onSiswaValueChange = entryViewModel::updateUiState,
                onSimpan = {
                    entryViewModel.saveSiswa()
                    navController.popBackStack()
                },
                onKembali = { navController.popBackStack() }
            )
        }
    }
}
