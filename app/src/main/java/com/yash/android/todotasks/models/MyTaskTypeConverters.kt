package com.yash.android.todotasks.models

import androidx.room.TypeConverter
import java.util.Date

class MyTaskTypeConverters {
    @TypeConverter
    public fun fromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    public fun toDate(millisSinceEpoch: Long): Date {
        return Date(millisSinceEpoch)
    }
}