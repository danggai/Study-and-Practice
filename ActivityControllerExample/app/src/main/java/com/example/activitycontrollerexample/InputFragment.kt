package com.example.activitycontrollerexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

/**
 * A simple [Fragment] subclass.
 */
class InputFragment : Fragment() {

    var btn1: Button? = null
    var edit1: EditText? = null
    var edit2: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_input, container, false)

        btn1 = view.findViewById(R.id.btn1)
        edit1 = view.findViewById(R.id.editTxt1)
        edit2 = view.findViewById(R.id.editTxt2)

        btn1?.setOnClickListener {
            var mActivity = activity as MainActivity    // activity를 통해 자신을 관리하는 activity에 접근 가능.

            mActivity.text1 = edit1?.text.toString()
            mActivity.text2 = edit2?.text.toString()

            mActivity.setFragment(mActivity.RESULT_FRAGMENT)
        }

        return view
    }
}
