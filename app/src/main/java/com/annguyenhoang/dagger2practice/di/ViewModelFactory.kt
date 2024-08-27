package com.annguyenhoang.dagger2practice.di

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.annguyenhoang.dagger2practice.notification.ui.TestViewModel
import dagger.MapKey
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(
    private val application: Application,
    private val providers: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var provider = providers[modelClass] ?: providers
            .asIterable()
            .firstOrNull { modelClass.isAssignableFrom(it.key) }
            ?.value

        provider = provider ?: throw IllegalArgumentException("Unknown model class: $modelClass")
        try {
            val vm = provider.get()
            val model = if (vm is TestViewModel) TestViewModel(application) else vm as T
            Log.d("TAG", "factory: $this, key: $modelClass, provider: ${provider}, model: $model")
            return vm as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}

@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)