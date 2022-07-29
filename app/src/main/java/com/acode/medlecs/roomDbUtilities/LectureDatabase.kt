package com.acode.lectureslist.roomDbUtilities

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.acode.lectureslist.dataClasses.Lecture


@Database(entities = [Lecture::class], version = 1, exportSchema = false)
//@TypeConverters(UUIDConverter::class)
abstract class LectureDatabase : RoomDatabase() {
    abstract fun lectureDao(): LectureDatabaseDao
}