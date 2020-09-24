package com.uninorte.a_202030_courseinfowithlogin.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.uninorte.a_202030_courseinfowithlogin.R
import com.uninorte.a_202030_courseinfowithlogin.model.Course
import com.uninorte.a_202030_courseinfowithlogin.viewmodel.CourseViewModel
import com.uninorte.a_202030_courseinfowithlogin.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {
    lateinit var navController: NavController
    private val loginViewModel: LoginViewModel by activityViewModels()
    private val courseViewModel: CourseViewModel by activityViewModels()
    private val adapter = CourseAdapter(ArrayList())
    lateinit var courses : List<Course>
    private var theToken : String = ""

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // requireView gets the root view for the fragment's layout
        // (the one returned by onCreateView).
        requireView().courses_rycler.adapter = adapter
        requireView().courses_rycler.layoutManager = LinearLayoutManager(requireContext())

        // get the live data and start observing
        courseViewModel.coursesLiveData.observe(getViewLifecycleOwner(), Observer {
            adapter.courses.clear()
            adapter.courses.addAll(it)
            adapter.notifyDataSetChanged()
        })

        navController = Navigation.findNavController(view)

        courseViewModel.getCourseData().observe(viewLifecycleOwner, Observer { users ->
            Log.d("MyOut", "Fragment  users list " + users.size)
        })

        view.findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {
            loginViewModel.signIn("augusto@a.com","123456","elprofesor").observe(viewLifecycleOwner, Observer { user ->
                //Log.d("MyOut", "Fragment  signIn " + user + " error " + user.error)
                theToken = user.token
                if (user.token != "") {
                    courseViewModel.addCourse("elprofesor",theToken)
                } else {
                    Toast.makeText(context, "Token failure " + user.error, Toast.LENGTH_LONG).show()
                }

            })
        }

        view.findViewById<Button>(R.id.buttonAddCourse).setOnClickListener {
            loginViewModel.signIn("augusto@a.com","123456","elprofesor").observe(viewLifecycleOwner, Observer { user ->
                //Log.d("MyOut", "Fragment  signIn " + user + " error " + user.error)
                theToken = user.token
                if (user.token != "") {
                    courseViewModel.getCourses("elprofesor",theToken)
                } else {
                    Toast.makeText(context, "Token failure " + user.error, Toast.LENGTH_LONG).show()
                }

            })

        }

        view.findViewById<Button>(R.id.logOutButton).setOnClickListener {
            navController!!.navigate(R.id.action_secondFragment_to_loginFragment)
        }
    }

}