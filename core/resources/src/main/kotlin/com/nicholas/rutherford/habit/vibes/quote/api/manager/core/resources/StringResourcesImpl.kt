package com.nicholas.rutherford.habit.vibes.quote.api.manager.core.resources

import android.app.Application
import android.content.Context
import java.io.InputStream

class StringResourcesImpl(private val application: Application) : StringResources {

    override fun getString(id: Int): String = application.getString(id)

    override fun getString(id: Int, vararg formatArgs: Any): String =
        application.getString(id, *formatArgs)

    override fun getQuantityString(id: Int, quantity: Int, vararg formatArgs: Any): String =
        application.resources.getQuantityString(id, quantity, *formatArgs)

    override fun getRawResource(id: Int): InputStream =
        application.resources.openRawResource(id)
}