package com.lambda.dagger.presentation.base.app.di

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule {

    companion object {
        @Singleton
        @Provides
        internal fun provideRequestOptionsCircleCrop():RequestOptions {
            return RequestOptions().circleCrop()
        }

        @Singleton
        @Provides
        internal fun provideGlideCircleCrop(application: Application, requestOptions: RequestOptions):RequestManager {
            return Glide.with(application.applicationContext).setDefaultRequestOptions(requestOptions)
        }
    }
}