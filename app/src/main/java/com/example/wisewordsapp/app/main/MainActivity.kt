package com.example.wisewordsapp.app.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.example.wisewordsapp.R
import com.example.wisewordsapp.app.network.GithubApi
import com.example.wisewordsapp.app.network.GithubResponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.jetbrains.anko.verbose

class MainActivity : MainUIActivity() {

    lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setMainContent()
        requestApi()
        setToolbar()
    }

    private fun setMainContent() {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        fr_main.addView(inflater.inflate(R.layout.layout_main, fr_main, false))
    }

    private fun requestApi() {
        compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            GithubApi.getRepoList("test")
                .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe({ response: GithubResponseModel ->
                for (item in response.items) {
                    Log.d("MainActivity", item.name)
                }
            }, { error: Throwable ->
                verbose("request Api result: " + "${error.localizedMessage}")
                toast("통신 중 장애 발생: " + "${error.localizedMessage}")
            }))
    }

    fun setToolbar() {
        val main_toolbar = findViewById<Toolbar> (R.id.toolbar)
        setSupportActionBar(main_toolbar)
        val actionBar = supportActionBar
        if(actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false)
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    //액션버튼 클릭 했을 때
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.menu_setting -> {
                //공유 버튼 눌렀을 때
                return super.onOptionsItemSelected(item)
            }
            else -> return false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    override fun onResume() {
        super.onResume()

    }
}
