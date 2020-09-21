package com.uninorte.a_202030_courseinfowithlogin.service.api.signup

import com.uninorte.a_202030_courseinfowithlogin.model.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SignUpApi {
    @POST("signup/")
    fun signUp(@Body user: User): Call<User>

    @FormUrlEncoded
    @POST("signup/")
    fun signUp2(@Field("email") email: String, @Field("password") password: String, @Field("username") username: String, @Field("name") name: String ): Call<ResponseBody>
}