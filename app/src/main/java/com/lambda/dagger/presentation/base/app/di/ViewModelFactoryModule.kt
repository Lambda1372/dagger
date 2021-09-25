package com.lambda.dagger.presentation.base.app.di

import androidx.lifecycle.ViewModelProvider
import com.lambda.dagger.presentation.base.app.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun provideViewModuleProviderFactory (viewModelProviderFactory: ViewModelProviderFactory):ViewModelProvider.Factory
}