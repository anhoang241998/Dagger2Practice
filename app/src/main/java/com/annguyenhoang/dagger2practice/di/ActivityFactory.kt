package com.annguyenhoang.dagger2practice.di

import com.annguyenhoang.dagger2practice.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [ActivityModule::class])
interface ActivityFactory {
    fun inject(act: MainActivity)
}