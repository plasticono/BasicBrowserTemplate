package edu.temple.basicbrowser

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private lateinit var urlEditText: EditText
    private lateinit var goButton: ImageButton
    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        urlEditText = findViewById(R.id.urlEditText)
        goButton = findViewById(R.id.goButton)
        webView = findViewById(R.id.webView)

        // Allow your browser to intercept hyperlink clicks
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }
        }

        webView.settings.javaScriptEnabled = true

        goButton.setOnClickListener {
            val url = urlEditText.text.toString()
            parseUrl(url)
        }

    }

    private fun parseUrl(url: String){
        if(!url.startsWith("http://") && !url.startsWith("https://")){
            webView.loadUrl("http://$url")
        }else{
            webView.loadUrl(url)
        }
    }

}