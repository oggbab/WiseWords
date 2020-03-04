package com.example.wisewordsapp.common.fragment

import androidx.fragment.app.Fragment

interface FragmentUtilImpl {

    fun replaceFragment(fragment: Fragment)
    fun addFragment(fragment: Fragment)
    fun finishFragment(fragment: Fragment)
}