package com.acode.lectureslist.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acode.lectureslist.dataClasses.Lecture
import com.acode.lectureslist.roomDbUtilities.LectureRepository
import com.google.android.gms.common.internal.safeparcel.SafeParcelable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LectureViewModel @Inject constructor(private val repository: LectureRepository): ViewModel(){

    private val _lecturesList = MutableStateFlow<List<Lecture>>(emptyList())
    val lecturesList = _lecturesList.asStateFlow()


    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllLectures().distinctUntilChanged().collect {
                if (it.isEmpty()){
                    Log.d("list", "Empty list")
                }else{
                    _lecturesList.value = it
                }
            }

        }
    }

//    private fun getAllLecturesList(){
//        viewModelScope.launch (Dispatchers.IO){
//            repository.getAllLectures().distinctUntilChanged().collect {
//                if (it.isNullOrEmpty()){
//                    Log.d("Status of List", "getAllLecturesList: Empty List")
//                }else{
//                    _lecturesList.value = it
//                }
//            }
//        }
//    }

    }