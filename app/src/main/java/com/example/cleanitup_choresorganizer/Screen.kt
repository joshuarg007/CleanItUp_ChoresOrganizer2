package com.example.cleanitup_choresorganizer

sealed class Screen(val name: String) {
    object Dashboard : Screen("dashboard")
    object TaskList : Screen("task_list")
}
