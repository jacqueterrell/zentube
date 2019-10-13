package com.technologies.zenlight.zentube.dependencyInjection.builder

import com.technologies.zenlight.zentube.userInterface.login.loginActivity.LoginActivity
import com.technologies.zenlight.zentube.userInterface.main.MainActivity
import com.technologies.zenlight.zentube.userInterface.splashScreen.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindSplashActivity() : SplashActivity

    @ContributesAndroidInjector
    abstract fun bindLoginActivity() : LoginActivity

    @ContributesAndroidInjector
    abstract fun bindMainActivity() : MainActivity
}