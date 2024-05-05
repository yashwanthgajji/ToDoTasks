package com.yash.android.todotasks

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface TaskDao {
    @Query("SELECT * FROM MyTask")
    public fun getAllTasks(): Flow<List<MyTask>>

    @Query("SELECT * FROM MyTask WHERE taskID=(:id)")
    public fun getTaskById(id: UUID): Flow<MyTask>
}