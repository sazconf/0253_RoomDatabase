package com.example.roomdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import com.example.meeting9.ui.theme.Meeting9Theme
import com.example.roomdb.view.uicontroller.SiswaApp

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
    SiswaApp(modifier = Modifier)
}
