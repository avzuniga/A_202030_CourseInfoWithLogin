package com.uninorte.a_202030_courseinfowithlogin.repository.api.course

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.uninorte.a_202030_courseinfowithlogin.model.APIError
import com.uninorte.a_202030_courseinfowithlogin.model.Course
import com.uninorte.a_202030_courseinfowithlogin.model.User
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class CourseApiService {

    companion object{

        fun getRestEngine(): CourseApi {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            return Retrofit.Builder()
                .baseUrl("https://movil-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(CourseApi::class.java)

        }
    }


     fun getCourses(user: String, token: String) : MutableLiveData<List<Course>>{
        val theResponse = MutableLiveData<List<Course>>()
         Log.d("MyOut", "getCourses with token  <" + token+">")
         getRestEngine().getCourses(user, token).enqueue(object: Callback<List<Course>>{
             override fun onResponse(call: Call<List<Course>>, response: Response<List<Course>>) {
                 if (response.isSuccessful) {
                     Log.d("MyOut", "OK isSuccessful " + response.body())
                     val loginResponse = response.body()
                     if (loginResponse != null) {
                         Log.d("MyOut", "OK isSuccessful token " )
                     }
                 } else {
                     Log.d("MyOut", "NOK  "+response.code() )
                     Log.d("MyOut", "NOK  "+response.errorBody().toString() )
                 }
             }

             override fun onFailure(call: Call<List<Course>>, t: Throwable) {
                 Log.d("MyOut","Failure "+t.message)
             }

         })

        return theResponse
    }

}