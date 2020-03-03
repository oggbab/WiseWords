package com.example.wisewordsapp.app.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.example.wisewordsapp.R
import com.example.wisewordsapp.app.network.GithubApi
import com.example.wisewordsapp.app.network.GithubResponseModel
import com.example.wisewordsapp.common.BaseActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.jetbrains.anko.verbose

class MainActivity : BaseActivity() {

    lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbar()
        setMainContent()
        requestApi()
    }

    private fun setMainContent() {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        fr_main.addView(inflater.inflate(R.layout.layout_main, fr_main, false))
    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)
        toolbar?.title = R.string.app_name.toString()
//        toolbar?.navigationIcon = R.drawable.ic_menu
        toolbar?.setNavigationOnClickListener {
            toast("Hello World!")
        }
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

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    override fun onResume() {
        super.onResume()

    }
}
