package com.annguyenhoang.dagger2practice

import android.app.Application
import com.annguyenhoang.dagger2practice.di.AppFactory
import com.annguyenhoang.dagger2practice.di.DaggerAppFactory

class App : Application() {

    lateinit var rootFactory: AppFactory

    override fun onCreate() {
        super.onCreate()
        rootFactory = DaggerAppFactory
            .builder()
            .provideApplicationContext(this@App)
            .build()
    }

}