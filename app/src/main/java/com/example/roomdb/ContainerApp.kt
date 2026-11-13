package com.example.roomdb

import android.content.Context
import com.example.roomdb.data.database.DatabaseSiswa
import com.example.roomdb.data.repository.OfflineRepositoriSiswa
import com.example.roomdb.data.repository.RepositoriSiswa

interface ContainerApp {
    val repositoriSiswa: RepositoriSiswa
}

class ContainerDataApp(context: Context) : ContainerApp {
    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositoriSiswa(DatabaseSiswa.getDatabase(context).siswaDao())
    }
}
