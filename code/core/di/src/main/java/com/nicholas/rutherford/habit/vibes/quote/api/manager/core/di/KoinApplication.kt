package com.nicholas.rutherford.habit.vibes.quote.api.manager.core.di

import android.app.Application
import com.nicholas.rutherford.habit.vibes.quote.api.manager.core.resources.StringResources
import com.nicholas.rutherford.habit.vibes.quote.api.manager.core.resources.StringResourcesImpl
import com.nicholas.rutherford.habit.vibes.quote.api.manager.feature.home.HomeScreenNavigation
import com.nicholas.rutherford.habit.vibes.quote.api.manager.feature.home.HomeScreenViewModel
import com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation.Navigator
import com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation.NavigatorImpl
import com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation.screennavigations.HomeScreenNavigationImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class KoinApplication : Application() {
    private val modules =
        module {
            single<StringResources> {
                StringResourcesImpl(application = androidApplication())
            }
            single<Navigator> {
                NavigatorImpl()
            }
            single<HomeScreenNavigation> {
                HomeScreenNavigationImpl(navigator = get())
            }
            viewModel {
                HomeScreenViewModel(
                    navigation = get(),
                    stringResources = get()
                )
            }
        }

    override fun onCreate() {
        super.onCreate()
        startKoinOnCreate()
    }

    fun startKoinOnCreate() {
        startKoin {
            androidContext(this@KoinApplication)
            modules(modules)
        }
    }
}
