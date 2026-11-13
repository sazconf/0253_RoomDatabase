package com.example.roomdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.meeting9.ui.theme.Meeting9Theme
import com.example.roomdb.ui.navigasi.PetaNavigasi

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Meeting9Theme {
                Surface {
                    AplikasiSiswaApp()
                }
            }
        }
    }
}

@Composable
private fun AplikasiSiswaApp() {
    val navController = rememberNavController()
    PetaNavigasi(navController = navController)
}
