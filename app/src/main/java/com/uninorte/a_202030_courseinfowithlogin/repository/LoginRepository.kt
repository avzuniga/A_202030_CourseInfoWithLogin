package com.uninorte.a_202030_courseinfowithlogin.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.uninorte.a_202030_courseinfowithlogin.repository.api.login.LoginApiService
import com.uninorte.a_202030_courseinfowithlogin.model.User
import java.util.concurrent.Flow

class LoginRepository {

    var userLiveData = MutableLiveData<User>()

    private val service = LoginApiService()

    fun signIn(user: User) = service.signIn(user)

     fun signUp(user: User) : LiveData<User> {
        return liveData<User> {
            val data = service.signUp(user)
            Log.d("MyOut", "Viewmodel  update")
           // emit(data)
        }
    }

     fun signUp2(user: User) = service.signUp(user)




    fun getUser() = userLiveData as LiveData<User>

}