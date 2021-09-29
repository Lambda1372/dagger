package com.lambda.dagger.presentation.auth.model

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("id")
    val id: String?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("website")
    val website: String?,
    )