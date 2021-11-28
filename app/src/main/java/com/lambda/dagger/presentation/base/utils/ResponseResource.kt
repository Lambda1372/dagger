package com.lambda.dagger.presentation.base.utils

class ResponseResource<T>(val status: State, val data: T?) {

    companion object {
        fun <T> loaded(data: T?): ResponseResource<T?> {
            return ResponseResource(State.LOADED, data)
        }

        fun <T> error(data: T?): ResponseResource<T?> {
            return ResponseResource(State.ERROR, data)
        }

        fun <T> loading(data: T?): ResponseResource<T?> {
            return ResponseResource(State.LOADING, data)
        }

        fun <T> logout(): ResponseResource<T?> {
            return ResponseResource(State.NOT_AUTHENTICATED, null)
        }
    }

    enum class State {
        LOADED, ERROR, LOADING, NOT_AUTHENTICATED
    }

}