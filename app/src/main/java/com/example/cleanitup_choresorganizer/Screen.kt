package com.example.cleanitup_choresorganizer

sealed class Screen(val route: String) {
    object Dashboard : Screen("dashboard")
    object TaskList : Screen("task_list")
}
