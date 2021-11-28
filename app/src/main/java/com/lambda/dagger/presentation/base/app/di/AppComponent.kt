package com.lambda.dagger.presentation.base.app.di

import android.app.Application
import com.lambda.dagger.presentation.base.app.view.BaseApplication
import com.lambda.dagger.presentation.base.utils.UserSessionManager
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivityBuilderModule::class, AppModule::class, ViewModelFactoryModule::class])
interface AppComponent : AndroidInjector<BaseApplication> {

    fun getUserSessionManager(): UserSessionManager

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}