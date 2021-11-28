package com.lambda.dagger.presentation.auth.view

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.RequestManager
import com.lambda.dagger.R
import com.lambda.dagger.presentation.auth.di.TestKhodam
import com.lambda.dagger.presentation.auth.viewmodel.AuthViewModel
import com.lambda.dagger.presentation.base.app.viewmodel.ViewModelProviderFactory
import com.lambda.dagger.presentation.base.utils.ResponseResource
import dagger.android.AndroidInjection
import javax.inject.Inject
import javax.inject.Named

class AuthActivity : AppCompatActivity() {
    private lateinit var imageViewAvatar:ImageView
    private lateinit var editTextTextPersonName:EditText
    private lateinit var buttonLogin:Button
    @Inject
    lateinit var requestManager: RequestManager

    @Inject
    @Named("BaseUrl")
    lateinit var ss1: String

    @Inject
    @Named("BaseUrl2")
    lateinit var ss2: String

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory
    private lateinit var authViewModel: AuthViewModel

    @Inject
    lateinit var testKhodamImp1 : Map<String, @JvmSuppressWildcards TestKhodam.Test>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        findViews()
        injectionSetup()
        subscribeObservers()
        clickListeners()
        Log.d("hereHere", "here " + testKhodamImp1["testKey1"]?.provide() + " " + ss1 + " " + ss2)
    }

    private fun findViews() {
        imageViewAvatar = findViewById(R.id.imageViewAvatar)
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName)
        buttonLogin = findViewById(R.id.buttonLogin)
    }

    private fun injectionSetup() {
        requestManager.load(R.drawable.ic_sample_avatar).into(imageViewAvatar)
        authViewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(AuthViewModel::class.java)
    }

    private fun subscribeObservers(){
        authViewModel.observeUser().observe(this,
            {
                when(it.status) {
                    ResponseResource.State.LOADED -> {
                        Log.d("hereSSS", it.data?.username.toString())
                    }
                    ResponseResource.State.ERROR -> {
                        //nothing
                    }
                    else -> {

                    }
                }
            }
        )
    }

    private fun clickListeners() {
        buttonLogin.setOnClickListener {
            authViewModel.getUser(editTextTextPersonName.text.toString())
        }
    }
}