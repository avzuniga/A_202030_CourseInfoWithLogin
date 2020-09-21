package com.uninorte.a_202030_courseinfowithlogin.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.uninorte.a_202030_courseinfowithlogin.model.User
import com.uninorte.a_202030_courseinfowithlogin.service.api.signup.SignUpApiService


class SignUpRepository {
    var userLiveData = MutableLiveData<User>()

    private val service = SignUpApiService()

    fun signUp(user: User) = service.signUp(user)

    fun getUser() = userLiveData as LiveData<User>


}