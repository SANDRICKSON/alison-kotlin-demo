package com.example.alisonxmldemo

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.alisonxmldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        webView = findViewById(R.id.web)
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.google.com/")
        onBackPressedDispatcher.addCallback(this,callBack)

    }


    val callBack = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            if(webView.canGoBack()){
                webView.goBack()
            }else{
                finish()
            }
        }
    }



}