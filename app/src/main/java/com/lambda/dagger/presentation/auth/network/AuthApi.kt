package com.lambda.dagger.presentation.auth.network

import com.lambda.dagger.presentation.auth.model.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {
    @GET("users/{id}")
    fun getUser(@Path("id") id:String):Single<User>
}