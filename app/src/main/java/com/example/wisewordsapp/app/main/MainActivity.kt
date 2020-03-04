package com.example.wisewordsapp.app.main

import android.os.Bundle
import com.example.wisewordsapp.R
import com.example.wisewordsapp.app.main.fragment.MainFragment

class MainActivity : MainUIActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragment()
    }

    private fun setFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fr_main, MainFragment()).addToBackStack(null)
            .commit()
    }

}
