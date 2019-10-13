package com.technologies.zenlight.zentube.userInterface.main

import com.technologies.zenlight.zentube.data.model.api.UserProfile
import com.technologies.zenlight.zentube.userInterface.base.BaseViewModel

class MainActivityViewModel : BaseViewModel() {


    /********* Getters and Setters ***********/

    var callbacks: MainActivityCallbacks? = null
    var userProfile: UserProfile? = null


    /********** OnClick Listeners **************/

    fun onLockScreenClicked() = callbacks?.onLockScreenClicked()

    fun onUnLockScreenLongClicked(): Boolean {
        callbacks?.onUnLockScreenLongClicked()
        return false
    }
}