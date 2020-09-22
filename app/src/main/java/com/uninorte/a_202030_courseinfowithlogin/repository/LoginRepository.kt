package com.uninorte.a_202030_courseinfowithlogin.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.uninorte.a_202030_courseinfowithlogin.service.api.login.LoginApiService
import com.uninorte.a_202030_courseinfowithlogin.model.User
import com.uninorte.a_202030_courseinfowithlogin.util.PreferenceProvider

class LoginRepository {

    var userLiveData = MutableLiveData<User>()
    var logged = MutableLiveData<Boolean>()
    var stateLogged : Boolean = false

    fun getLogged() = logged as LiveData<Boolean>

    /*init {
        stateLogged = PreferenceProvider.getValue()!!
        logged.value = stateLogged;
    }*/

    fun setLogged(state: Boolean){
        stateLogged = state
        logged.value = stateLogged;
        PreferenceProvider.setValue(state)
    }

    private val service = LoginApiService()

    fun signIn(user: User) = service.signIn(user)

    fun getUser() = userLiveData as LiveData<User>

}