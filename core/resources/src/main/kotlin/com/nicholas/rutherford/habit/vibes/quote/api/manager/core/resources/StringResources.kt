package com.nicholas.rutherford.habit.vibes.quote.api.manager.core.resources

import androidx.annotation.PluralsRes
import androidx.annotation.RawRes
import androidx.annotation.StringRes
import java.io.InputStream

interface StringResources {

    fun getString(@StringRes id: Int): String

    fun getString(@StringRes id: Int, vararg formatArgs: Any): String

    fun getQuantityString(@PluralsRes id: Int, quantity: Int, vararg formatArgs: Any): String

    fun getRawResource(@RawRes id: Int): InputStream
}