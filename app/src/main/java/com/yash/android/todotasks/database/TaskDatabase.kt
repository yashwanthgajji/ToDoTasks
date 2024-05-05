package com.yash.android.todotasks.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yash.android.todotasks.models.MyTask
import com.yash.android.todotasks.models.MyTaskTypeConverters

@Database(entities = [MyTask::class], version = 1, exportSchema = false)
@TypeConverters(MyTaskTypeConverters::class)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}