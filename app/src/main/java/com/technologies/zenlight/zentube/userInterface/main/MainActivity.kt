package com.technologies.zenlight.zentube.userInterface.main

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.WindowManager
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.ViewModelProviders
import com.technologies.zenlight.zentube.BR
import com.technologies.zenlight.zentube.R
import com.technologies.zenlight.zentube.data.AppDataManager
import com.technologies.zenlight.zentube.databinding.FragmentContainerBinding
import com.technologies.zenlight.zentube.databinding.WebviewLayoutBinding
import com.technologies.zenlight.zentube.userInterface.base.BaseActivity
import com.technologies.zenlight.zentube.utils.showAlertDialog
import javax.inject.Inject
import android.net.http.SslCertificate.restoreState
import android.net.http.SslCertificate.saveState
import android.webkit.WebChromeClient
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService



class MainActivity : BaseActivity<WebviewLayoutBinding, MainActivityViewModel>(), MainActivityCallbacks {


    override var viewModel: MainActivityViewModel? = null

    override var bindingVariable: Int = BR.viewModel

    override var layoutId: Int = R.layout.webview_layout

    override var progressSpinner: View? = null

    var customView: View? = null

    companion object {
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        super.onCreate(savedInstanceState)
        dataBinding.viewModel = viewModel
        viewModel?.callbacks = this
        if (savedInstanceState == null) {
            setUpWebView()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        dataBinding.webviewMain.saveState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        dataBinding.webviewMain.restoreState(savedInstanceState)
    }

    override fun onLockScreenClicked() {
        dataBinding.btnLockScreen.visibility = View.INVISIBLE
        dataBinding.btnUnlockScreen.visibility = View.VISIBLE
        dataBinding.layoutLockScreen.visibility = View.VISIBLE
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

    }

    override fun onUnLockScreenLongClicked() {
        dataBinding.btnLockScreen.visibility = View.VISIBLE
        dataBinding.btnUnlockScreen.visibility = View.INVISIBLE
        dataBinding.layoutLockScreen.visibility = View.INVISIBLE
        window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

    private fun setUpWebView() {
        dataBinding.webviewMain.settings.javaScriptEnabled = true
        dataBinding.webviewMain.settings.domStorageEnabled = true
        dataBinding.webviewMain.settings.builtInZoomControls = true
        dataBinding.webviewMain.loadUrl("https://www.google.com")
        dataBinding.webviewMain.webViewClient = WebClient()

    }


    inner class WebClient : WebViewClient() {


        @TargetApi(Build.VERSION_CODES.N)
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            val url: String = request?.url?.toString() ?: ""
            view?.loadUrl(url)
            return false
        }

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return false
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            dataBinding.layoutProgress.visibility = View.VISIBLE
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            dataBinding.layoutProgress.visibility = View.GONE
        }


    }

//    inner class MyChrome: WebChromeClient() {
//
//
//        override fun onHideCustomView() {
//            super.onHideCustomView();
//            dataBinding.webviewMain.visibility = View.VISIBLE;
//            customViewContainer.setVisibility(View.GONE);
//        }
//
//        override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
//            super.onShowCustomView(view, callback)
//        }
//    }

}