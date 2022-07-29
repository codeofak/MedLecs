package com.acode.lectureslist.roomDbUtilities

import com.acode.lectureslist.dataClasses.Lecture
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LectureRepository @Inject constructor(private val lectureDatabaseDao: LectureDatabaseDao){


    suspend fun getAllLectures(): Flow<List<Lecture>> =
        lectureDatabaseDao.getLectures().flowOn(Dispatchers.IO).conflate()

//    suspend fun getLecturesBySubject(subject: String)=
//        lectureDatabaseDao.getLecturesBySubject(subject)
//
//    suspend fun getLecturesByPlatform(platform: String) =
//        lectureDatabaseDao.getLecturesByPlatform(platform)
}