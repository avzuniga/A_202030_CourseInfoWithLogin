package com.uninorte.a_202030_courseinfowithlogin.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.uninorte.a_202030_courseinfowithlogin.R
import com.uninorte.a_202030_courseinfowithlogin.model.User
import com.uninorte.a_202030_courseinfowithlogin.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    val loginViewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        loginViewModel.getUser().observe(getViewLifecycleOwner(), Observer { user ->
            run {
                if (user != null) {
                    Log.d("MyOut", "Fragment  userLiveData " + user + " error " + user.error)
                    if (user.token != "") {
                        Toast.makeText(context, "Token " + user.token, Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(context, "Token failure " + user.error, Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        })

        view.findViewById<Button>(R.id.signInButton).setOnClickListener {
            val email : String =  "334dd@33.com"
            val clave : String = "123456"
            loginViewModel.signIn(email,clave).observe(getViewLifecycleOwner(), Observer { user ->

                Log.d("MyOut", "Fragment  userLiveData222 " + user + " error " + user.error)
                if (user.token != "") {
                    Toast.makeText(context, "Token22 " + user.token, Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Token22 failure " + user.error, Toast.LENGTH_LONG)
                        .show()
                }

            })
        }

        view.findViewById<Button>(R.id.signUpButton).setOnClickListener {
            val email : String =  "334dd@33.com"
            val clave : String = "123456"
            loginViewModel.signUp(email,clave).observe(getViewLifecycleOwner(), Observer { user ->

                    Log.d("MyOut", "Fragment  userLiveData222 " + user + " error " + user.error)
                    if (user.token != "") {
                        Toast.makeText(context, "Token22 " + user.token, Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(context, "Token22 failure " + user.error, Toast.LENGTH_LONG)
                            .show()
                    }

            })
        }
    }
}