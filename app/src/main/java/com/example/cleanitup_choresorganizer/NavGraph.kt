package com.example.cleanitup_choresorganizer

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cleanitup_choresorganizer.viewmodel.ChoreViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: ChoreViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Dashboard.name
    ) {
        composable(Screen.Dashboard.name) {
            DashboardScreen(navController = navController)
        }
        composable(Screen.TaskList.name) {
            TaskListScreen(navController = navController, viewModel = viewModel)
        }
    }
}
