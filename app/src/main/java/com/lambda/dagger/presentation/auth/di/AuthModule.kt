package com.lambda.dagger.presentation.auth.di

import com.lambda.dagger.presentation.auth.network.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class AuthModule {

    companion object {
        @Provides
        internal fun provideAuthApi(retrofit: Retrofit): AuthApi {
            return retrofit.create(AuthApi::class.java)
        }
    }
}