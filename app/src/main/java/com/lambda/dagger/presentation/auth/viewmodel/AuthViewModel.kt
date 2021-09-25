package com.lambda.dagger.presentation.auth.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class AuthViewModel @Inject constructor() : ViewModel() {
    init {
        Log.d("HereAuth", "here")
    }
}