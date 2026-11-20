package com.example.roomdb.view.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.roomdb.view.HalamanDetailSiswa
import com.example.roomdb.view.HalamanEdit
import com.example.roomdb.view.HalamanEntry
import com.example.roomdb.view.HalamanHome
import com.example.roomdb.view.route.DestinasiDetailSiswa
import com.example.roomdb.view.route.DestinasiEditSiswa
import com.example.roomdb.view.route.DestinasiEntry
import com.example.roomdb.view.route.DestinasiHome
import com.example.roomdb.viewmodel.provider.PenyediaViewModel

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
            HalamanHome(
                viewModel = viewModel(factory = PenyediaViewModel.Factory),
                onTambahSiswa = { navController.navigate(DestinasiEntry.route) },
                onDetailClick = { itemId ->
                    navController.navigate("${DestinasiDetailSiswa.route}/$itemId")
                }
            )
        }
        composable(DestinasiEntry.route) {
            HalamanEntry(
                viewModel = viewModel(factory = PenyediaViewModel.Factory),
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(
            route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiDetailSiswa.itemIdArg) {
                    type = NavType.IntType
                }
            )
        ) {
            HalamanDetailSiswa(
                viewModel = viewModel(factory = PenyediaViewModel.Factory),
                navigateToEditItem = { itemId ->
                    navController.navigate("${DestinasiEditSiswa.route}/$itemId")
                },
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(
            route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiEditSiswa.itemIdArg) {
                    type = NavType.IntType
                }
            )
        ) {
            HalamanEdit(
                viewModel = viewModel(factory = PenyediaViewModel.Factory),
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}
