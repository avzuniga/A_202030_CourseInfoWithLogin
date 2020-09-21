package com.uninorte.a_202030_courseinfowithlogin.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.uninorte.a_202030_courseinfowithlogin.R
import com.uninorte.a_202030_courseinfowithlogin.viewmodel.SignUpViewModel


class SignUpFragment : Fragment() {

    private val signupViewModel: SignUpViewModel by activityViewModels()
    private var theToken : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.signUpPassButton).setOnClickListener {
            val email : String =  "augusto@a.com"
            val clave : String = "123456"
            val usuario : String = "elprofesor"
            signupViewModel.signUp(email,clave, usuario).observe(viewLifecycleOwner, Observer { user ->

                Log.d("MyOut", "Fragment  signUp " + user + " error " + user.error)
                theToken = user.token


            })
        }

    }
}