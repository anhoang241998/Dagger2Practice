package com.annguyenhoang.dagger2practice.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppFactory {
    @Component.Builder
    interface Builder {
        fun build(): AppFactory

        @BindsInstance
        fun provideApplicationContext(application: Application): Builder
    }

    fun activityFactory(): ActivityFactory
}