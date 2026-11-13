package com.example.roomdb

import android.app.Application

class AplikasiSiswa : Application() {
    lateinit var containerApp: ContainerApp
        private set

    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerDataApp(this)
    }
}
