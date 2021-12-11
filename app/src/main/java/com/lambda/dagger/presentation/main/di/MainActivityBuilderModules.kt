package com.lambda.dagger.presentation.main.di

import com.lambda.dagger.presentation.main.view.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityBuilderModules {

    @ContributesAndroidInjector
    internal abstract fun contributeProfileFragment():ProfileFragment
}