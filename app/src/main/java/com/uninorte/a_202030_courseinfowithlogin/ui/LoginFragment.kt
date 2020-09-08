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
import com.uninorte.a_202030_courseinfowithlogin.viewmodel.CourseViewModel
import com.uninorte.a_202030_courseinfowithlogin.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    val loginViewModel: LoginViewModel by activityViewModels()
    val courseViewModel: CourseViewModel by activityViewModels()
    var theToken : String = ""

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.signInButton).setOnClickListener {
            val email : String =  "augusto@a.com"
            val clave : String = "123456"
            val usuario : String = "elprofesor"
            loginViewModel.signIn(email,clave,usuario).observe(getViewLifecycleOwner(), Observer { user ->

                Log.d("MyOut", "Fragment  signIn " + user + " error " + user.error)
                theToken = user.token
                if (user.token != "") {
                    Toast.makeText(context, "Token22 " + user.token, Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Token22 failure " + user.error, Toast.LENGTH_LONG)
                        .show()
                }

            })
        }

        view.findViewById<Button>(R.id.signUpButton).setOnClickListener {
            val email : String =  "augusto@a.com"
            val clave : String = "123456"
            val usuario : String = "elprofesor"
            loginViewModel.signUp(email,clave, usuario).observe(getViewLifecycleOwner(), Observer { user ->

                    Log.d("MyOut", "Fragment  signUp " + user + " error " + user.error)
                    theToken = user.token


            })
        }

        view.findViewById<Button>(R.id.buttonGetCourses).setOnClickListener {
            val usuario : String = "elprofesor"
            courseViewModel.getCourses(usuario,theToken).observe(getViewLifecycleOwner(), Observer { courses ->
                Log.d("MyOut", "Fragment courses size "+courses.size)

            })
        }

        view.findViewById<Button>(R.id.buttonAddCourse).setOnClickListener {
            val usuario : String = "elprofesor"
            courseViewModel.addCourse(usuario,theToken).observe(getViewLifecycleOwner(), Observer { course ->
                Log.d("MyOut", "Fragment  added "+course.name)

            })
        }


    }
}