package com.uninorte.a_202030_courseinfowithlogin.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.uninorte.a_202030_courseinfowithlogin.R
import com.uninorte.a_202030_courseinfowithlogin.model.User
import com.uninorte.a_202030_courseinfowithlogin.viewmodel.CourseViewModel
import com.uninorte.a_202030_courseinfowithlogin.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by activityViewModels()
    private val courseViewModel: CourseViewModel by activityViewModels()
    private var theToken : String = ""

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        courseViewModel.getCourseData().observe(viewLifecycleOwner, Observer { users ->
            Log.d("MyOut", "Fragment  users list " + users.size)
        })


        view.findViewById<Button>(R.id.signInButton).setOnClickListener {
            val emailb : EditText = view.findViewById<EditText>(R.id.textemail)
            val email : String =  emailb.toString()
            val claveb : EditText = view.findViewById<EditText>(R.id.textpassword)
            val clave : String = claveb.toString()
            val usuariob: EditText = view.findViewById<EditText>(R.id.textusuario)
            val usuario : String = usuariob.toString()
            loginViewModel.signIn(email,clave,usuario).observe(viewLifecycleOwner, Observer { user ->

                //Log.d("MyOut", "Fragment  signIn " + user + " error " + user.error)
                theToken = user.token
                if (user.token != "") {
                    Toast.makeText(context, "Token " + user.token, Toast.LENGTH_LONG).show()
                    courseViewModel.getCourses("elprofesor",theToken)
                } else {
                    Toast.makeText(context, "Token failure " + user.error, Toast.LENGTH_LONG)
                        .show()
                }

            })
        }



    }
}