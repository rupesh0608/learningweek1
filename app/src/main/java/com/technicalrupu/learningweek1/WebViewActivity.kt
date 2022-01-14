package com.technicalrupu.learningweek1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ProgressBar
import androidx.activity.result.contract.ActivityResultContracts
import com.technicalrupu.learningweek1.Helper.Button

class WebViewActivity : AppCompatActivity() {


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        title="Web View"

        val btn=Button(this)
        val searchBtn=btn.create(R.id.searchBtn)
        searchBtn.setOnClickListener {
            val searchBox=findViewById<EditText>(R.id.searchBox)
            val webView=com.technicalrupu.learningweek1.Helper.WebView(this)
            val url="https://www.google.com/search?q="+searchBox.text
            webView.withViewClient(R.id.webView,url,false,R.id.progress)
        }
    }
    override fun onBackPressed() {
        val webView=com.technicalrupu.learningweek1.Helper.WebView(this)
        webView.backFunctionality(R.id.webView,super.onBackPressed())
    }
}