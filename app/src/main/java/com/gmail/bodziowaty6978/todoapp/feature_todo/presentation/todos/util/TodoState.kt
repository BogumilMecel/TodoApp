package com.gmail.bodziowaty6978.todoapp.feature_todo.presentation.todos.util

import com.gmail.bodziowaty6978.todoapp.feature_todo.domain.model.Todo

data class TodoState(
    val todos:List<Todo> = emptyList()
)