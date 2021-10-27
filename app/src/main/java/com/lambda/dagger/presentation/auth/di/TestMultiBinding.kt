package com.lambda.dagger.presentation.auth.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class TestMultiBinding {
    @Binds
    @IntoMap
    @StringKey("testKey1")
    abstract fun bindTest1(testKhodamImp1 : TestKhodam.TestImp1): TestKhodam.Test

    @Binds
    @IntoMap
    @StringKey("testKey2")
    abstract fun bindTest2(testKhodamImp2 : TestKhodam.TestImp2): TestKhodam.Test
}