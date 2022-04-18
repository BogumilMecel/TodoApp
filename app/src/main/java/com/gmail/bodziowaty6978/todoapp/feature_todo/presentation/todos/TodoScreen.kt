package com.gmail.bodziowaty6978.todoapp.feature_todo.presentation.todos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.gmail.bodziowaty6978.todoapp.feature_todo.presentation.todos.components.GreetingsSection
import com.gmail.bodziowaty6978.todoapp.feature_todo.presentation.todos.components.TodoSection
import com.gmail.bodziowaty6978.todoapp.feature_todo.presentation.todos.util.TodoEvent
import com.gmail.bodziowaty6978.todoapp.ui.theme.DarkGrey
import com.gmail.bodziowaty6978.todoapp.ui.theme.LightRed

@Composable
fun TodoScreen(
    viewModel: TodoViewModel = hiltViewModel(),
) {
    val state = viewModel.state

    LaunchedEffect(true){
        viewModel.getTodos()
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                backgroundColor = LightRed
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add icon"
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkGrey)
        ) {

            GreetingsSection()
            TodoSection(
                todoItems = state.value.todos,
                onEvent = {
                    viewModel.onEvent(TodoEvent.CompleteTodo(state.value.todos[it]))
                }
            )

        }
    }
}