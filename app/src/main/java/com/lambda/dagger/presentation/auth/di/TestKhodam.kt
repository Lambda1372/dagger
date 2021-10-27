package com.lambda.dagger.presentation.auth.di

import javax.inject.Inject


class TestKhodam {
    interface Test {
        fun provide():String
    }

    class TestImp1 @Inject constructor() :Test{
        override fun provide(): String {
            return "testValue1"
        }
    }

    class TestImp2 @Inject constructor() :Test{
        override fun provide(): String {
            return "testValue2"
        }
    }
}