package com.lambda.dagger.presentation.base.app.di

import android.app.Application
import com.lambda.dagger.presentation.base.app.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector


@Component(modules = [AndroidInjectionModule::class,ActivityBuilderModule::class])
interface AppComponent : AndroidInjector<BaseApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}