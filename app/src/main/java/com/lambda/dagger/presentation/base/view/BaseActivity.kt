package com.lambda.dagger.presentation.base.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lambda.dagger.presentation.base.utils.ResponseResource
import com.lambda.dagger.presentation.base.utils.UserSessionManager
import dagger.android.AndroidInjection
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {
    @Inject
    lateinit var sessionManager:UserSessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setUpSubscribe()
    }

    private fun setUpSubscribe() {
        sessionManager.getUserLiveData().observe(this, {
            when(it.status) {
                ResponseResource.State.NOT_AUTHENTICATED -> {
                  Toast.makeText(this, "logout", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}