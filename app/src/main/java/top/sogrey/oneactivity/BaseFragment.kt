package top.sogrey.oneactivity

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView

open class BaseFragment : Fragment() {


    fun addFragment(fragment: Fragment, transit: Int, name: String?) {

        val fragmentManager = getMainFragmentManager()
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        setFragmentChangeAnimations(fragmentTransaction)
        if (!fragment.isAdded) {
            if (name != null) {
                fragmentTransaction.add(R.id.container1, fragment, name)
            } else {
                fragmentTransaction.add(R.id.container1, fragment)
            }
            fragmentTransaction.addToBackStack(name)
            fragmentTransaction.setTransition(transit)
            fragmentTransaction.commitAllowingStateLoss()
        }
    }


    fun addFragment(fragment: Fragment, transit: Int, name: String?, fragmentManager: FragmentManager) {

        //        FragmentManager fragmentManager = getMainFragmentManager();
        val fragmentTransaction = fragmentManager.beginTransaction()
        setFragmentChangeAnimations(fragmentTransaction)
        if (!fragment.isAdded) {
            if (name != null) {
                fragmentTransaction.add(R.id.container1, fragment, name)
            } else {
                fragmentTransaction.add(R.id.container1, fragment)
            }
            fragmentTransaction.addToBackStack(name)
            fragmentTransaction.setTransition(transit)
            fragmentTransaction.commitAllowingStateLoss()
        }
    }


    /**
     * 如果当前Fragment是内嵌在另一个Fragment中的子Fragment，若想获取Activity 的FragmentManager，可重写改方法
     * getActivity().getSupportFragmentManager()
     */
    protected fun getMainFragmentManager(): FragmentManager? {
        return fragmentManager
    }

    /**
     * 添加了变换动画
     */
    protected fun setFragmentChangeAnimations(ft: FragmentTransaction) {

        ft.setCustomAnimations(
            R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R
                .anim.slide_out_right
        )

    }

    /**
     * 添加fragment
     *
     * @param fragment
     */
    fun addFragment(fragment: Fragment) {
        addFragment(fragment, 0, null)
    }


    /**
     * 判断软键盘 状态
     */
    fun solt() {
        val view = activity!!.window.peekDecorView()
        if (view != null) {
            //关闭
            val inputmanger = activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputmanger.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }

    /**
     * 关闭上一个fragment
     */
    protected fun popBackFragment() {
        solt()
        val fragmentManager = getMainFragmentManager()
        fragmentManager!!.popBackStack()
    }


    /**
     * 关闭所有的fragment
     */
    protected fun popAllFragment() {
        solt()
        val fragmentManager = getMainFragmentManager()
        try {
            fragmentManager!!.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            //fragmentManager.executePendingTransactions();
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * 替换当前的主Fragment
     */
    fun replaceFragment(fragment: Fragment, tag: String) {
        val ft = getMainFragmentManager()!!.beginTransaction()
        setFragmentChangeAnimations(ft)
        // ft.addToBackStack(tag);
        ft.replace(R.id.container1, fragment, tag).commit()
    }


    /**
     * 打印日志
     * @param message
     */
    fun Systens(message: String) {
        println(message)
    }


    protected var mActivity: Activity? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.mActivity = context as Activity?
    }

    override fun onDetach() {
        super.onDetach()
        if (mActivity != null) {
            mActivity = null
        }
    }
}
