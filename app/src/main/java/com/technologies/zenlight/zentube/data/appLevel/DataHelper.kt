package com.technologies.zenlight.zentube.data.appLevel

import android.content.Context
import com.technologies.zenlight.zentube.utils.AppSharedPrefs

interface DataHelper {

    fun getAppContext() : Context

    fun getSharedPrefs(): AppSharedPrefs
}