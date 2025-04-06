# Chore Organizer App

A simple Android app built with Kotlin and Jetpack Compose to help organize and manage household chores.

## Features

- View a list of chores on the Task List screen
- Add new chores through a dialog
- Mark chores as completed using checkboxes
- Remove all completed chores with a delete button in the top app bar
- Navigate between Dashboard and Task List screens

## Screens

### Dashboard

- Displays a welcome message
- Includes a button to navigate to the Task List

### Task List

- Shows a scrollable list of chores
- Each item displays:
    - The name of the chore
    - A checkbox to mark it as done
- Floating Action Button to add new chores
- Top app bar with a delete button to remove all completed chores

## File Structure

- `MainActivity.kt` – Sets up the view model and loads the navigation graph
- `NavGraph.kt` – Defines the navigation routes
- `DashboardScreen.kt` – Displays the welcome screen
- `TaskListScreen.kt` – Main screen to view, complete, and add chores
- `ChoreViewModel.kt` – Stores the chore list and handles chore actions
- `Chore.kt` – Data class representing a single chore

## Logic Overview

- Chores are stored in a `mutableStateListOf` inside the `ChoreViewModel`
- New chores are added through a dialog input
- Checkboxes toggle the `isDone` value of a chore
- Completed chores are removed by calling a function in the view model
