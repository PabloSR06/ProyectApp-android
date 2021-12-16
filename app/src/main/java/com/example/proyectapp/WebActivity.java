package com.example.proyectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    private WebView miVisorWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        String url = "https://www.googlrrrre.com";
        //String url = "https://pglproyect.000webhostapp.com/";

        miVisorWeb = (WebView) findViewById(R.id.webview);
        final WebSettings ajustesVisorWeb = miVisorWeb.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);
        miVisorWeb.loadUrl(url);
        //miVisorWeb.setWebViewClient(new WebViewClient());


        miVisorWeb.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                goErrorActivity();
                super.onReceivedError(view, errorCode, description, failingUrl);

            }
        });
    }

    public void goErrorActivity (){
        Intent intent= new Intent (this, ErrorActivity.class);
        intent.putExtra("error_code", 0);
        startActivity(intent);
    }


}

