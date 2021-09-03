package com.lambda.dagger.presentation.base.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lambda.dagger.R
import dagger.android.DaggerActivity
import javax.inject.Inject

class AuthActivity : DaggerActivity() {
    @Inject
    lateinit var s:String
    @Inject
    lateinit var s2:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        Toast.makeText(this, s + "-" +s2, Toast.LENGTH_SHORT).show()
    }
}