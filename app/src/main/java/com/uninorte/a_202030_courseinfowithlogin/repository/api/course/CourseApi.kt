package com.uninorte.a_202030_courseinfowithlogin.repository.api.course

import com.uninorte.a_202030_courseinfowithlogin.model.Course
import com.uninorte.a_202030_courseinfowithlogin.model.Post
import com.uninorte.a_202030_courseinfowithlogin.model.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface CourseApi {

    @FormUrlEncoded
    @POST("{dbId}/courses/")
    fun getCourses(@Path("dbId") user: String, @Field("Token") token: String): Call<List<Course>>

}