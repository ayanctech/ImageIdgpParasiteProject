package com.actech.protozoan_parasite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class Acknowledgements extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acknowledgements);


    }

    public void devack(View view) {
        startActivity(new Intent(this,devack.class));
    }

    public void projack(View view) {
        startActivity(new Intent(this,proj_ack.class));
    }
}
