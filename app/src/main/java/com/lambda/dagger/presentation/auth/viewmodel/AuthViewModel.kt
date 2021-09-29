package com.lambda.dagger.presentation.auth.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.lambda.dagger.presentation.auth.di.AuthModule
import com.lambda.dagger.presentation.auth.model.User
import com.lambda.dagger.presentation.auth.network.AuthApi
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(private var authApi: AuthApi) : ViewModel() {

    fun getUser(id: Int) {
        val d:Disposable = authApi.getUser(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                       Log.d("hereUser", it.username.toString())
            },{
                Log.d("hereE","hghgh")
            })
    }
}