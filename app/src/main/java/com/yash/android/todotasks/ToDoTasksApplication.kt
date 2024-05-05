package com.yash.android.todotasks

import android.app.Application
import com.yash.android.todotasks.database.TaskRepository

class ToDoTasksApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        TaskRepository.initialize(this)
    }
}