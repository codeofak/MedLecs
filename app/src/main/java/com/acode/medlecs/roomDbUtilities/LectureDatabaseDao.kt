package com.acode.lectureslist.roomDbUtilities

import androidx.room.Dao
import androidx.room.Query
import com.acode.lectureslist.dataClasses.Lecture
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.selects.select


@Dao
interface LectureDatabaseDao{

    @Query("SELECT * FROM lecture_tbl")
    fun getLectures() : Flow<List<Lecture>>

//    @Query("select * from lecture_tbl where id =:id")
//    suspend fun getLecturesById(id: String): Lecture

//    @Query("select * from lecture_tbl where lec_subject =:subject")
//    suspend fun getLecturesBySubject(subject: String) : Lecture
//
//    @Query("select * from lecture_tbl where lec_platform =:platform")
//    suspend fun getLecturesByPlatform(platform:String) : Lecture

}
