package com.example.wisewordsapp.app

import android.os.Bundle
import com.example.wisewordsapp.R
import com.example.wisewordsapp.app.main.MainActivity
import com.example.wisewordsapp.common.BaseActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.anko.startActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        goMain()
    }

    override fun onResume() {
        super.onResume()
        goMain()
    }

    fun goMain() {
        GlobalScope.launch {
            delay(2000L)
            startActivity<MainActivity>()
        }
    }
}
