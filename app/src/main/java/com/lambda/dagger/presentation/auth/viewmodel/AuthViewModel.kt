package com.lambda.dagger.presentation.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lambda.dagger.presentation.auth.model.User
import com.lambda.dagger.presentation.auth.network.AuthApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(private var authApi: AuthApi) : BaseViewModel() {
    private var mutableLiveData = MutableLiveData<Result>()
    fun getUser(id: String) {
        val disposable:Disposable = authApi.getUser(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mutableLiveData.value = Result(it)
            },{
            })

        addDisposable(disposable)
    }

    fun observeUser():LiveData<Result>{
        return mutableLiveData
    }

    data class Result (
        val user: User,
    )
}