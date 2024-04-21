package com.yash.android.todotasks

import java.util.UUID

data class MyTask(
    val taskID: UUID,
    val title: String,
    val description: String,
    val status: TaskStatus
)