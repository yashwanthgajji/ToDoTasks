package com.yash.android.todotasks

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.flow.Flow
import java.util.UUID

private const val DATABASE_NAME = "mytask-database"
class TaskRepository private constructor(context: Context){
    private val database: TaskDatabase = Room.databaseBuilder(
        context.applicationContext,
        TaskDatabase::class.java,
        DATABASE_NAME
    ).build()

    public suspend fun getALlTasks(): Flow<List<MyTask>> = database.taskDao().getAllTasks()
    public suspend fun getTask(id: UUID): Flow<MyTask> = database.taskDao().getTaskById(id)

    companion object {
        private var INSTANCE: TaskRepository ?= null

        public fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = TaskRepository(context)
            }
        }

        public fun getInstance(): TaskRepository {
            return INSTANCE?: throw IllegalStateException("Task Repository must be initialized before use")
        }
    }
}