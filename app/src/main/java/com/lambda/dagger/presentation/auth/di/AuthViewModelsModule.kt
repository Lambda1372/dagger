package com.lambda.dagger.presentation.auth.di

import androidx.lifecycle.ViewModel
import com.lambda.dagger.presentation.auth.viewmodel.AuthViewModel
import com.lambda.dagger.presentation.base.app.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(authViewModel:AuthViewModel): ViewModel
}