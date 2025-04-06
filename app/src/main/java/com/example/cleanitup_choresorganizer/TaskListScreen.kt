package com.example.cleanitup_choresorganizer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cleanitup_choresorganizer.model.Chore
import com.example.cleanitup_choresorganizer.viewmodel.ChoreViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen(navController: NavHostController, viewModel: ChoreViewModel) {
    val chores = viewModel.chores

    var showDialog by remember { mutableStateOf(false) }
    var newChoreName by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Chore List") },
                actions = {
                    IconButton(onClick = { viewModel.removeCompletedChores() }) {
                        Icon(Icons.Default.Delete, contentDescription = "Remove Completed")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                showDialog = true
            }) {
                Text("+")
            }
        }
    ) { padding ->

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Add New Chore") },
                text = {
                    TextField(
                        value = newChoreName,
                        onValueChange = { newChoreName = it },
                        label = { Text("Chore Name") }
                    )
                },
                confirmButton = {
                    TextButton(onClick = {
                        if (newChoreName.isNotBlank()) {
                            viewModel.addChore(newChoreName.trim())
                            newChoreName = ""
                            showDialog = false
                        }
                    }) {
                        Text("Add")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        showDialog = false
                        newChoreName = ""
                    }) {
                        Text("Cancel")
                    }
                }
            )
        }

        LazyColumn(
            contentPadding = padding,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(chores) { chore ->
                ChoreItem(
                    chore = chore,
                    onCheckedChange = { isChecked: Boolean ->
                        viewModel.toggleChoreDone(chore.id, isChecked)
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun ChoreItem(chore: Chore, onCheckedChange: (Boolean) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = chore.name,
                style = MaterialTheme.typography.titleMedium
            )
            Checkbox(
                checked = chore.isDone,
                onCheckedChange = onCheckedChange
            )
        }
    }
}
