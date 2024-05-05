package com.yash.android.todotasks

import android.app.Application

class ToDoTasksApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        TaskRepository.initialize(this)
    }
}