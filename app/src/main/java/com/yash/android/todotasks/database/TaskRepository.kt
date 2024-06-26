package com.yash.android.todotasks.database

import android.content.Context
import androidx.room.Room
import com.yash.android.todotasks.models.MyTask
import kotlinx.coroutines.flow.Flow
import java.util.UUID

private const val DATABASE_NAME = "mytask-database"
class TaskRepository private constructor(context: Context){
    private val database: TaskDatabase = Room.databaseBuilder(
        context.applicationContext,
        TaskDatabase::class.java,
        DATABASE_NAME
    ).build()

    public fun getALlTasks(): Flow<List<MyTask>> = database.taskDao().getAllTasks()
    public fun getTask(id: UUID): Flow<MyTask> = database.taskDao().getTaskById(id)

    companion object {
        private var INSTANCE: TaskRepository?= null

        public fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = TaskRepository(context)
            }
        }

        public fun getInstance(): TaskRepository {
            return INSTANCE ?: throw IllegalStateException("Task Repository must be initialized before use")
        }
    }
}