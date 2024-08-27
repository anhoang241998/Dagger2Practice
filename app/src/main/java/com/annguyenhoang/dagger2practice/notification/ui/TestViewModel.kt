package com.annguyenhoang.dagger2practice.notification.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import com.annguyenhoang.dagger2practice.R
import javax.inject.Inject

class TestViewModel @Inject constructor(private val app: Application) : ViewModel() {
    fun printString(getString: (String) -> Unit) {
        val appName = app.getString(R.string.app_name)
        getString(appName)
    }

}