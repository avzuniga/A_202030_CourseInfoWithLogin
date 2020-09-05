package com.uninorte.a_202030_courseinfowithlogin.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uninorte.a_202030_courseinfowithlogin.model.Course
import com.uninorte.a_202030_courseinfowithlogin.model.User
import com.uninorte.a_202030_courseinfowithlogin.repository.CourseRepository
import com.uninorte.a_202030_courseinfowithlogin.repository.LoginRepository

class CourseViewModel : ViewModel() {


    private val repository = CourseRepository()

    fun getCourses(user: String, token: String) : MutableLiveData<List<Course>> {
        Log.d("MyOut", "CourseViewModel getCourses with token  <" + token+">")
        return repository.getCourses(user, token)
    }

}
