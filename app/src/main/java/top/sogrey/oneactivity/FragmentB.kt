package top.sogrey.oneactivity

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentB : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       var view = inflater.inflate(R.layout.fragment_b, container, false)
        view!!.findViewById<Button>(R.id.back).setOnClickListener(View.OnClickListener { popBackFragment() })

        // Inflate the layout for this fragment
        return view
    }
}
