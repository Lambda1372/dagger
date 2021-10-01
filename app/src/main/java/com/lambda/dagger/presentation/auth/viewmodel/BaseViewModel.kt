package com.lambda.dagger.presentation.auth.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel :ViewModel(){
    private val compositeDisposable = CompositeDisposable()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun addDisposable(disposable:Disposable) {
        compositeDisposable.add(disposable)
    }
}
