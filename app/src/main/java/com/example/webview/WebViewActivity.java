package com.example.webview;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class WebViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_web_view);

        WebView webView = findViewById(R.id.webView);


        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("direccion");

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

    }


}