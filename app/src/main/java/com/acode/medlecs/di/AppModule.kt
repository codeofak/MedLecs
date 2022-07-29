package com.acode.lectureslist.di

import android.content.Context
import android.content.res.Resources
import androidx.room.Room
import com.acode.lectureslist.roomDbUtilities.LectureDatabase
import com.acode.lectureslist.roomDbUtilities.LectureDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideLecturesDao(lectureDatabase: LectureDatabase): LectureDatabaseDao =
        lectureDatabase.lectureDao()


    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): LectureDatabase =
        Room.databaseBuilder(
            context,
            LectureDatabase::class.java,
            "lecture_tbl"
        )
            .createFromAsset("database/lecture_tbl.db")
            .build()
}