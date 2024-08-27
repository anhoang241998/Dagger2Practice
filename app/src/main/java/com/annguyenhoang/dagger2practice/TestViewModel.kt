package com.annguyenhoang.dagger2practice

import android.app.Application
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class Page {
    private var page = 1

    fun nextPage() {
        page++
    }
}

class TestViewModel @Inject constructor(private val app: Application) : ViewModel() {
    var page: Page? = null

    fun doIt() {
        val nav: Page = page ?: return
        nav.nextPage()
    }

    fun printString(getString: (String) -> Unit) {
        val appName = app.getString(R.string.app_name)
        getString(appName)
    }

}