package com.actech.protozoan_parasite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Acknowledgements extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acknowledgements);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        WebView myWebView = findViewById(R.id.ackwv);
        myWebView.loadUrl("file:///android_asset/ackn.html");

    }
}
