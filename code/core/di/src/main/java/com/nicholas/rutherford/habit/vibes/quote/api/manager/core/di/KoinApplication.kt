package com.nicholas.rutherford.habit.vibes.quote.api.manager.core.di

import android.app.Application
import com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation.Navigator
import com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation.NavigatorImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class KoinApplication: Application() {
    private val modules =
        module {
            single<Navigator> {
                NavigatorImpl()
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