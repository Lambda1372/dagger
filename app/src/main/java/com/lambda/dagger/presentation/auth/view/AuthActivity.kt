package com.lambda.dagger.presentation.auth.view

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.RequestManager
import com.lambda.dagger.R
import com.lambda.dagger.presentation.auth.viewmodel.AuthViewModel
import com.lambda.dagger.presentation.base.app.viewmodel.ViewModelProviderFactory
import dagger.android.AndroidInjection
import dagger.android.DaggerActivity
import javax.inject.Inject

class AuthActivity : AppCompatActivity() {
    lateinit var imageViewAvatar:ImageView
    @Inject
    lateinit var requestManager: RequestManager

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        imageViewAvatar = findViewById(R.id.imageViewAvatar)
        requestManager.load(R.drawable.ic_sample_avatar).into(imageViewAvatar)
        authViewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(AuthViewModel::class.java)
        authViewModel.getUser(1)
    }
}