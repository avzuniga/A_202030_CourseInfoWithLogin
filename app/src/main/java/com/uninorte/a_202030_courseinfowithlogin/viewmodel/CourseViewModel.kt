package com.uninorte.a_202030_courseinfowithlogin.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uninorte.a_202030_courseinfowithlogin.model.Course
import com.uninorte.a_202030_courseinfowithlogin.model.User
import com.uninorte.a_202030_courseinfowithlogin.repository.CourseRepository
import com.uninorte.a_202030_courseinfowithlogin.repository.LoginRepository
import kotlinx.coroutines.launch

class CourseViewModel : ViewModel() {

    private val repository = CourseRepository()
    private val courses = mutableListOf<Course>()
    val coursesLiveData = MutableLiveData<List<Course>>()



    fun getCourses(user: String, token: String) {
        viewModelScope.launch {
            courses.addAll(repository.getCourses(user, token))
            coursesLiveData.postValue(courses)

        }
    }



    fun addCourse(user: String, token: String)  {
        Log.d("MyOut", "CourseViewModel addCourses with token  <$token>")
         repository.addCourse(user, token)
    }

    fun getCourseData() = repository.getCourseData()

}

