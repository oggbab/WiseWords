package com.example.wisewordsapp.common.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

class FragmentUtil : FragmentUtilImpl {

    private var fragmentContainerId = 0
    private lateinit var fragmentManager: FragmentManager
    private lateinit var activity: FragmentActivity

    constructor( activity: FragmentActivity, fragmentContainerId: Int) {
        this.activity = activity
        this.fragmentContainerId = fragmentContainerId
        fragmentManager = activity.supportFragmentManager
    }

    override fun addFragment(fragment: Fragment) {
        fragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .add(fragmentContainerId, fragment)
            .commitAllowingStateLoss()
    }

    override fun replaceFragment(fragment: Fragment) {
        fragmentManager
            .beginTransaction()
            .replace(fragmentContainerId, fragment)
            .commitAllowingStateLoss()
    }

    override fun finishFragment(fragment: Fragment) {
        activity.finish()
    }

}