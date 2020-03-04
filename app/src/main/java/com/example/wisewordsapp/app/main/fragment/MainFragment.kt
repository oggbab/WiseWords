package com.example.wisewordsapp.app.main.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.wisewordsapp.R
import com.example.wisewordsapp.app.network.GithubApi
import com.example.wisewordsapp.app.network.GithubResponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.jetbrains.anko.verbose

class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, null)
        // 처리
        return view
    }


/*    private fun requestApi() {
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
    }*/

}
