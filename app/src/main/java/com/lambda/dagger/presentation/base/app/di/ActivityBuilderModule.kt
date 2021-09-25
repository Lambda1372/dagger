package com.lambda.dagger.presentation.base.app.di

import com.lambda.dagger.presentation.auth.di.AuthViewModelsModule
import com.lambda.dagger.presentation.auth.view.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [AuthViewModelsModule::class])
    abstract fun contributeAuthActivity(): AuthActivity
}