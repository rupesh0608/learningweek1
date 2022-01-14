package com.technicalrupu.learningweek1.Helper

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.webkit.WebView
import android.widget.ProgressBar

class WebView( val ref:Activity) {

     @SuppressLint("SetJavaScriptEnabled")
     fun withViewClient(webViewID:Int, url:String, redirection: Boolean, progressBarId:Int){
         val webView=ref.findViewById<WebView>(webViewID)
         webView.webViewClient=WebViewClient(progressBarId,redirection)
         webView.settings.javaScriptEnabled = true
         webView.settings.setSupportZoom(true)
         webView.loadUrl(url)
    }
    @SuppressLint("SetJavaScriptEnabled")
    fun withChromeClient(webViewID:Int, url:String, progressBarId:Int){
        val webView=ref.findViewById<WebView>(webViewID)
        webView.webChromeClient=WebChromeClient(progressBarId)
        webView.settings.javaScriptEnabled =true
        webView.settings.setSupportZoom(true)
        webView.loadUrl(url)
    }

    fun backFunctionality(webViewID:Int,onBackPressed:Unit)
    {
        val webView =ref.findViewById<WebView>(webViewID)
        if (webView.canGoBack())

            webView.goBack()
        else
            onBackPressed
    }

  inner  class WebViewClient(private val progressBarId:Int, private val redirection:Boolean):
        android.webkit.WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            if (url != null) {
                view?.loadUrl(url)
            }
            return redirection
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            val progressBar=ref.findViewById<ProgressBar>(progressBarId)
            progressBar.visibility=View.GONE
        }
    }
   inner class WebChromeClient(private val progressBarId:Int) : android.webkit.WebChromeClient(){
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
            val progressBar=ref.findViewById<ProgressBar>(progressBarId)
            progressBar.progress=newProgress
            if(newProgress!=100)
            {
                progressBar.visibility = View.VISIBLE
            }else{
                progressBar.visibility = View.GONE
            }
        }
    }
}