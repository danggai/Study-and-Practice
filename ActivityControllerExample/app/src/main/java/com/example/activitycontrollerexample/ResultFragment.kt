package com.example.activitycontrollerexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 */
class ResultFragment : Fragment() {

    var btn1: Button? = null
    var text1: TextView? = null
    var text2: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_result, container, false)

        btn1 = view.findViewById(R.id.btn1)
        text1 = view.findViewById(R.id.txtView1)
        text2 = view.findViewById(R.id.txtView2)

        var mActivity = activity as MainActivity

        text1?.text = mActivity.text1
        text2?.text = mActivity.text2

        btn1?.setOnClickListener {
            mActivity.supportFragmentManager.popBackStack()
        }

        return view
    }

}
