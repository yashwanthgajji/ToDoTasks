package com.yash.android.todotasks

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity
data class MyTask(
    @PrimaryKey val taskID: UUID,
    val title: String,
    val description: String,
    val status: TaskStatus,
    val dateCreated: Date
)