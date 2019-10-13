package com.technologies.zenlight.zentube.userInterface.splashScreen

import android.os.Bundle
import android.view.View
import com.technologies.zenlight.zentube.BR
import com.technologies.zenlight.zentube.R
import com.technologies.zenlight.zentube.databinding.SplashActivityLayoutBinding
import com.technologies.zenlight.zentube.userInterface.base.BaseActivity
import com.technologies.zenlight.zentube.userInterface.main.MainActivity

class SplashActivity: BaseActivity<SplashActivityLayoutBinding, SplashViewModel>() {

    override var viewModel: SplashViewModel? = null

    override var bindingVariable: Int = BR.viewModel

    override var layoutId: Int = R.layout.splash_activity_layout

    override var progressSpinner: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            startActivity(MainActivity.newIntent(this))
    }
}