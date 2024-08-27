package com.annguyenhoang.dagger2practice.di

import androidx.lifecycle.ViewModel
import com.annguyenhoang.dagger2practice.TestViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(value = TestViewModel::class)
    fun bindViewModel(vm: TestViewModel): ViewModel
}