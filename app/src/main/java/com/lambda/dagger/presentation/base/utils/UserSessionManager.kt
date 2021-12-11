package com.lambda.dagger.presentation.base.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.lambda.dagger.presentation.auth.model.User
import javax.inject.Inject

class UserSessionManager @Inject constructor() {
    private val mediatorLiveData:MediatorLiveData<ResponseResource<User?>> = MediatorLiveData()

    fun authenticateUser(source: LiveData<ResponseResource<User?>?>) {
        mediatorLiveData.addSource(source, object : Observer<ResponseResource<User?>?> {
            override fun onChanged(responseResource: ResponseResource<User?>?) {
                mediatorLiveData.value = responseResource
                mediatorLiveData.removeSource(source)
            }
        })
    }

    fun getUserLiveData():LiveData<ResponseResource<User?>> {
        return mediatorLiveData
    }
}