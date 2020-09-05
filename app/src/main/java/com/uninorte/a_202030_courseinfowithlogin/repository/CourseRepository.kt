package com.uninorte.a_202030_courseinfowithlogin.repository

import com.uninorte.a_202030_courseinfowithlogin.model.User
import com.uninorte.a_202030_courseinfowithlogin.repository.api.course.CourseApiService
import com.uninorte.a_202030_courseinfowithlogin.repository.api.login.LoginApiService

class CourseRepository {

    private val service = CourseApiService()

    fun getCourses(user: String, token: String) = service.getCourses(user,token)
}