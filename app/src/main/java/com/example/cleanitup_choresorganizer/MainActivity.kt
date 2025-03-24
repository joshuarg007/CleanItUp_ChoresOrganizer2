package com.example.cleanitup_choresorganizer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.cleanitup_choresorganizer.ui.theme.CleanItUpChoresOrganizerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanItUpChoresOrganizerTheme {
                Surface {
                    ChoresApp()
                }
            }
        }
    }
}

@Composable
fun ChoresApp() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.Dashboard.route) {
        composable(Screen.Dashboard.route) { DashboardScreen(navController) }
        composable(Screen.TaskList.route) { TaskListScreen(navController) }
    }
}
