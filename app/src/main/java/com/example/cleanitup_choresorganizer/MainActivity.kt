package com.example.cleanitup_choresorganizer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.cleanitup_choresorganizer.viewmodel.ChoreViewModel
import com.example.cleanitup_choresorganizer.ui.theme.CleanItUpChoresOrganizerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create the view model
        val viewModel: ChoreViewModel by viewModels()

        setContent {
            CleanItUpChoresOrganizerTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController, viewModel = viewModel)
            }
        }
    }
}
