package com.example.roomdb.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.roomdb.AplikasiSiswa
import com.example.roomdb.viewmodel.DetailViewModel
import com.example.roomdb.viewmodel.EditViewModel
import com.example.roomdb.viewmodel.EntryViewModel
import com.example.roomdb.viewmodel.HomeViewModel

object PenyediaViewModel {
    val Factory: ViewModelProvider.Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiSiswa().containerApp.repositoriSiswa)
        }
        initializer {
            EntryViewModel(aplikasiSiswa().containerApp.repositoriSiswa)
        }
        initializer {
            DetailViewModel(
                createSavedStateHandle(),
                aplikasiSiswa().containerApp.repositoriSiswa
            )
        }
        initializer {
            EditViewModel(
                createSavedStateHandle(),
                aplikasiSiswa().containerApp.repositoriSiswa
            )
        }
    }
}

fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)
