package com.actech.protozoan_parasite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class devs extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devs);


    }

    @Override
    public void onBackPressed() {
            startActivity(new Intent(getApplicationContext(), OptionsPage.class));
    }
}