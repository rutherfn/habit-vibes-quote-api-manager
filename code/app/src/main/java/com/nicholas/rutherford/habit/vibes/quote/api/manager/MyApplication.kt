package com.nicholas.rutherford.habit.vibes.quote.api.manager

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {
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
            androidContext(this@MyApplication)
            modules(modules)
        }
    }
}
