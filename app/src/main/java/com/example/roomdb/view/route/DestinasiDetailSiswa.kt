package com.example.roomdb.view.route

import com.example.roomdb.R

object DestinasiDetailSiswa : DestinasiNavigasi {
    override val route = "item_details"
    override val titleRes = R.string.detail_siswa
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}
