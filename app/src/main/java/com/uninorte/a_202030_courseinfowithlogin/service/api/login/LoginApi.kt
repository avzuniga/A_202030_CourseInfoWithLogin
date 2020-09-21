package com.uninorte.a_202030_courseinfowithlogin.service.api.login

import com.uninorte.a_202030_courseinfowithlogin.model.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginApi {

    @POST("signin/")
    fun signIn(@Body user: User): Call<User>


}