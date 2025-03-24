package com.example.cleanitup_choresorganizer.ui

sealed class Screen(val route: String) {
    object Dashboard : Screen("dashboard")
    object TaskList : Screen("task_list")
}
