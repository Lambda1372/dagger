package com.lambda.dagger.presentation.main

import android.os.Bundle
import com.lambda.dagger.R
import com.lambda.dagger.presentation.base.view.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}