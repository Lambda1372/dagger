package com.lambda.dagger.presentation.base.app.di

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.lambda.dagger.presentation.base.utils.Constants
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
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

        @Singleton
        @Provides
        @Named("BaseUrl")
        internal fun provideBaseUrl():String {
            return Constants.BASE_URL
        }

        @Singleton
        @Provides
        @Named("BaseUrl2")
        internal fun provideBaseUrl2():String {
            return Constants.BASE_URL
        }

        @Singleton
        @Provides
        internal fun provideRetrofit(@Named("BaseUrl") baseUrl:String, client: OkHttpClient):Retrofit {
            return Retrofit
                .Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
        }

        @Singleton
        @Provides
        internal fun provideOkHttpClient(): OkHttpClient {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
        }
    }
}