package com.yash.android.todotasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TaskListViewModel : ViewModel() {
    private val taskRepository = TaskRepository.getInstance()
    private val _myTasks: MutableStateFlow<List<MyTask>> = MutableStateFlow(emptyList())
    public val myTasks: StateFlow<List<MyTask>>
        get() = _myTasks.asStateFlow()

    init {
        viewModelScope.launch {
            taskRepository.getALlTasks().collect {
                _myTasks.value = it
            }
        }
    }
}