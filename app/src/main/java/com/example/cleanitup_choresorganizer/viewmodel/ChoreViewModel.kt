package com.example.cleanitup_choresorganizer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.cleanitup_choresorganizer.model.Chore

class ChoreViewModel : ViewModel() {

    // Backing list of chores
    private val _chores = mutableStateListOf<Chore>()

    // Publicly exposed read-only list
    val chores: SnapshotStateList<Chore> get() = _chores

    init {
        // Sample/mock data
        _chores.addAll(
            listOf(
                Chore(name = "Take out trash"),
                Chore(name = "Wash dishes"),
                Chore(name = "Do laundry")
            )
        )
    }

    fun addChore(name: String) {
        val newChore = Chore(name = name)
        _chores.add(newChore)
    }

    fun removeChore(chore: Chore) {
        _chores.remove(chore)
    }

    fun removeCompletedChores() {
        _chores.removeAll { it.isDone }
    }

    fun toggleChoreDone(choreId: String, isDone: Boolean) {
        val index = _chores.indexOfFirst { it.id == choreId }
        if (index != -1) {
            _chores[index] = _chores[index].copy(isDone = isDone)
        }
    }

}
