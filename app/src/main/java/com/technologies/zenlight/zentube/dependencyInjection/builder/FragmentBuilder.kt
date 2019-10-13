package com.technologies.zenlight.zentube.dependencyInjection.builder

import com.technologies.zenlight.zentube.userInterface.login.forgotPassword.ForgotPasswordFragment
import com.technologies.zenlight.zentube.userInterface.login.loginFragment.LoginFragment
import com.technologies.zenlight.zentube.userInterface.login.signUp.SignUpFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    internal abstract fun bindSignUpFragment(): SignUpFragment

    @ContributesAndroidInjector
    internal abstract fun bindForgotPasswordFragment(): ForgotPasswordFragment
}