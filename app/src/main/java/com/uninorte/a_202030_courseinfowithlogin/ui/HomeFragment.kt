package com.uninorte.a_202030_courseinfowithlogin.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import com.uninorte.a_202030_courseinfowithlogin.R
import com.uninorte.a_202030_courseinfowithlogin.viewmodel.CourseViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class HomeFragment : Fragment() {
    private val courseViewModel: CourseViewModel by activityViewModels()
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

        courseViewModel.getCourseData().observe(viewLifecycleOwner, Observer { users ->
            Log.d("MyOut", "Fragment  users list " + users.size)
        })
        view.findViewById<Button>(R.id.buttonAddCourse).setOnClickListener {
            val usuario : String = "elprofesor"
            courseViewModel.addCourse(usuario,theToken)
        }

    }
}