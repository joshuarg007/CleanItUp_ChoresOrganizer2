package com.example.cleanitup_choresorganizer.model

import java.util.UUID

data class Chore(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val isDone: Boolean = false
)
