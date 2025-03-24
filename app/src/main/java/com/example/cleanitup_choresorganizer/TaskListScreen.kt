package com.example.cleanitup_choresorganizer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cleanitup_choresorganizer.model.Chore
import com.example.cleanitup_choresorganizer.viewmodel.ChoreViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen(navController: NavHostController, viewModel: ChoreViewModel) {
    val chores = viewModel.chores

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Chore List") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // Placeholder for future: Add Chore screen or dialog
            }) {
                Text("+")
            }
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(chores) { chore ->
                ChoreItem(chore)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun ChoreItem(chore: Chore) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = chore.name, style = MaterialTheme.typography.titleMedium)
        }
    }
}
