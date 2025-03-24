package com.example.cleanitup_choresorganizer

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DashboardScreen(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Dashboard") }) }
    ) { padding ->
        Button(
            onClick = { navController.navigate(Screen.TaskList.route) },
            modifier = Modifier.padding(padding)
        ) {
            Text("Go to Task List")
        }
    }
}
