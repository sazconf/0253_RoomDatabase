package com.example.roomdb.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.roomdb.AplikasiSiswa
import com.example.roomdb.ui.siswa.EntryViewModel
import com.example.roomdb.ui.siswa.HomeViewModel

object PenyediaViewModel {
    fun Factory(extras: CreationExtras): ViewModelProvider.Factory =
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = extras[
                    ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY
                ] as AplikasiSiswa
                val repository = application.containerApp.repositoriSiswa
                return when {
                    modelClass.isAssignableFrom(HomeViewModel::class.java) ->
                        HomeViewModel(repository) as T
                    modelClass.isAssignableFrom(EntryViewModel::class.java) ->
                        EntryViewModel(repository) as T
                    else -> error("Unknown ViewModel class: ${modelClass.name}")
                }
            }
        }
}
