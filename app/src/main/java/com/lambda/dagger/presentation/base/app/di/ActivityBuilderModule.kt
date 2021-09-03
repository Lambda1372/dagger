package com.lambda.dagger.presentation.base.app.di

import com.lambda.dagger.presentation.base.auth.AuthActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeAuthActivity():AuthActivity

    companion object {
        @Provides
        internal fun getString():String {
            return "Test Message"
        }
    }
}