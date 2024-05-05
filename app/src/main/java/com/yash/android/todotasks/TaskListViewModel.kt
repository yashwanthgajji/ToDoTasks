package com.yash.android.todotasks

import androidx.lifecycle.ViewModel
import java.util.Date
import java.util.UUID

class TaskListViewModel : ViewModel(){
    val myTasks = mutableListOf<MyTask>()

    init {
        for (i in 0..100) {
            val myTask = MyTask(
                taskID = UUID.randomUUID(),
                title = "Task-$i",
                description = "This is description for task-$i",
                status = when {
                    (i % 3) == 0 -> TaskStatus.InProgress
                    i % 5 == 0 -> TaskStatus.Done
                    else -> TaskStatus.Todo
                },
                Date()
            )
            myTasks += myTask
        }
    }
}