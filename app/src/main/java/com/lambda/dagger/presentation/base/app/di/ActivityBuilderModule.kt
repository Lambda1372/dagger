package com.lambda.dagger.presentation.base.app.di

import com.lambda.dagger.presentation.auth.di.AuthModule
import com.lambda.dagger.presentation.auth.di.AuthViewModelsModule
import com.lambda.dagger.presentation.auth.di.TestMultiBinding
import com.lambda.dagger.presentation.auth.view.AuthActivity
import com.lambda.dagger.presentation.main.di.MainActivityBuilderModules
import com.lambda.dagger.presentation.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [AuthViewModelsModule::class, AuthModule::class, TestMultiBinding::class])
    abstract fun contributeAuthActivity(): AuthActivity

    @ContributesAndroidInjector(modules = [MainActivityBuilderModules::class])
    abstract fun contributeMainActivity(): MainActivity
}