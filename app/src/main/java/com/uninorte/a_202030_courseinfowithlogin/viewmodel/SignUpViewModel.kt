package com.uninorte.a_202030_courseinfowithlogin.viewmodel

import androidx.lifecycle.*
import com.uninorte.a_202030_courseinfowithlogin.model.User
import com.uninorte.a_202030_courseinfowithlogin.repository.SignUpRepository


class SignUpViewModel : ViewModel(){

    var userLiveData = MutableLiveData<User>()
    private val repository = SignUpRepository()

    fun signUp(email: String, clave: String, usuario : String) =
        repository.signUp(User(email, clave, usuario, usuario,"",""))

    fun getUser() = userLiveData
}