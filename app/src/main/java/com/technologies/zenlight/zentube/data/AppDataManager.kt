package com.technologies.zenlight.zentube.data

import com.technologies.zenlight.zentube.data.appLevel.AppDataHelper
import javax.inject.Inject

class AppDataManager @Inject constructor(private val appDataHelper: AppDataHelper) : DataManager {

    override fun getAppContext() = appDataHelper.getAppContext()

    override fun getSharedPrefs() = appDataHelper.getSharedPrefs()
}