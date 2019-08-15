package top.sogrey.oneactivity

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class FragmentA : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var  view = inflater.inflate(R.layout.fragment_a, container, false)
        view!!.findViewById<Button>(R.id.btn_add_fragmentB).setOnClickListener(View.OnClickListener { addFragment(FragmentB()) })
        return view
    }

}
