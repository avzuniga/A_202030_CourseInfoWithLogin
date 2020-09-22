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
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.uninorte.a_202030_courseinfowithlogin.R
import com.uninorte.a_202030_courseinfowithlogin.viewmodel.SignUpViewModel


class SignUpFragment : Fragment() {
    lateinit var navController: NavController
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
        navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.signUpButton).setOnClickListener {
            val emailb : EditText = view.findViewById<EditText>(R.id.textemail)
            val email : String =  emailb.text.toString()
            val claveb : EditText = view.findViewById<EditText>(R.id.textpassword)
            val clave : String = claveb.text.toString()
            val usuariob: EditText = view.findViewById<EditText>(R.id.textusuario)
            val usuario : String = usuariob.text.toString()

            /*val email : String =  "augusto@a.com"
            val clave : String = "123456"
            val usuario : String = "elprofesor"*/

            signupViewModel.signUp(email,clave, usuario).observe(viewLifecycleOwner, Observer { user ->
                Toast.makeText(context, "You have been registered: " + user.username, Toast.LENGTH_LONG).show()
                Log.d("MyOut", "Fragment  signUp " + user + " error " + user.error)
                theToken = user.token


            })
        }

        view.findViewById<Button>(R.id.backButton).setOnClickListener{
            navController!!.navigate(R.id.action_signUpFragment_to_loginFragment)
        }

    }
}