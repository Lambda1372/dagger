package com.lambda.dagger.presentation.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lambda.dagger.presentation.auth.model.User
import com.lambda.dagger.presentation.auth.network.AuthApi
import com.lambda.dagger.presentation.base.app.viewmodel.BaseViewModel
import com.lambda.dagger.presentation.base.utils.ResponseResource
import com.lambda.dagger.presentation.base.utils.UserSessionManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(private var authApi: AuthApi, private var userSessionManager: UserSessionManager) : BaseViewModel() {
    fun getUser(id: String) {
        val disposable:Disposable = authApi.getUser(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                //userSessionManager.authenticateUser()
               // mutableLiveData.value = ResponseResource.loaded(it)
            },{
               // mutableLiveData.value = ResponseResource.error(null)
            })

        addDisposable(disposable)
    }

    fun observeUser():LiveData<ResponseResource<User?>>{
        return userSessionManager.getUserLiveData()
    }
}