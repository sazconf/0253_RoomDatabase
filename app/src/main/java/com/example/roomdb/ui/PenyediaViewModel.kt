package com.example.roomdb.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdb.AplikasiSiswa
import com.example.roomdb.ui.siswa.EntryViewModel
import com.example.roomdb.ui.siswa.HomeViewModel

object PenyediaViewModel {
    fun Factory(application: AplikasiSiswa): ViewModelProvider.Factory =
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
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
