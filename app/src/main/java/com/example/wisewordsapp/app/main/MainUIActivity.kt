package com.example.wisewordsapp.app.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.wisewordsapp.R
import com.example.wisewordsapp.common.activity.BaseActivity
import com.example.wisewordsapp.common.fragment.FragmentUtil
import com.example.wisewordsapp.common.fragment.FragmentUtilImpl

open class MainUIActivity : BaseActivity(), FragmentUtilImpl {

    private lateinit var mFragmentUtil: FragmentUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mFragmentUtil = FragmentUtil(this, R.id.fr_main)
        setCustomToolbar()
    }


    fun setCustomToolbar() {
        val main_toolbar = findViewById<Toolbar> (R.id.toolbar)
        setSupportActionBar(main_toolbar)

        val customToolbar = layoutInflater.inflate(R.layout.layout_toolbar, null) as View

        val actionBar = supportActionBar
        if(actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(false)
            actionBar.setDisplayHomeAsUpEnabled(false)
            actionBar.setDisplayShowCustomEnabled(true)
            actionBar.setDisplayShowTitleEnabled(false)
        }

        val layoutParams : ActionBar.LayoutParams = ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT)
        actionBar?.setCustomView(customToolbar, layoutParams)

    }


    override fun replaceFragment(fragment: Fragment) {
        mFragmentUtil.replaceFragment(fragment)
    }

    override fun addFragment(fragment: Fragment) {
        mFragmentUtil.addFragment(fragment)
    }

    override fun finishFragment(fragment: Fragment) {
        mFragmentUtil.finishFragment(fragment)
    }


    override fun onBackPressed() {
        finish()
    }
}