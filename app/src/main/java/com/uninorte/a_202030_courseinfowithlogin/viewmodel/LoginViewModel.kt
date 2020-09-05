package com.uninorte.a_202030_courseinfowithlogin.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.uninorte.a_202030_courseinfowithlogin.model.Post
import com.uninorte.a_202030_courseinfowithlogin.repository.LoginRepository
import com.uninorte.a_202030_courseinfowithlogin.model.User
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel(){

    var userLiveData = MutableLiveData<User>()


    private val repository = LoginRepository()
    public fun signIn(email: String, clave: String) {
        viewModelScope.launch {

        }
    }

    fun getUser() = userLiveData

     fun signUp(email: String, clave: String) : MutableLiveData<User>{

         return repository.signUp2(User(email, clave, email, email,"",""))
        viewModelScope.launch {

        }

        // viewModelScope.launch {
      //       userLiveData.value =  repository.signUp2(User(email, clave, email, email,"","")).asLiveData()
        // }

         //this.userLiveData = liveData {
         //    emit(repository.signUp2(User(email, clave, email, email,"","")))
        // }
       // userLiveData.value = repository.signUp(myUser)


    }
}