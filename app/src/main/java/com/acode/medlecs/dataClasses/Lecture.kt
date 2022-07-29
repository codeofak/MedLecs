package com.acode.lectureslist.dataClasses

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "lecture_tbl")
data class Lecture(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id:Int,

    @ColumnInfo(name = "lec_subject")
    val subject: String,

    @ColumnInfo(name = "lec_title")
    val title: String,

    @ColumnInfo(name = "lec_platform")
    val platform: String
)
