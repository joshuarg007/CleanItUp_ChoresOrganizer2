package com.example.cleanitup_choresorganizer.model

data class Task(
    val id: String = "",
    val title: String,
    val description: String = "",
    val assignedTo: String = "",
    val dueDate: String = "",
    val isCompleted: Boolean = false
)
