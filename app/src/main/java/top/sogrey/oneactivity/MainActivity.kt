package top.sogrey.oneactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.popBackStack()
            supportFragmentManager.beginTransaction().add(
                R.id.container1, FragmentA()
            ).commitAllowingStateLoss()
        }
    }
}
