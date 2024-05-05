package com.yash.android.todotasks

import androidx.room.Dao
import androidx.room.Query
import java.util.UUID

@Dao
interface TaskDao {
    @Query("SELECT * FROM MyTask")
    public suspend fun getAllTasks(): List<MyTask>

    @Query("SELECT * FROM MyTask WHERE taskID=(:id)")
    public suspend fun getTaskById(id: UUID): MyTask
}