package com.actech.protozoan_parasite;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static java.net.Proxy.Type.HTTP;

public class devack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devack);
    /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fb);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"ayan.chowdhury2050@gmail.com"});
                //i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                //i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(devack.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        */
    }

    public void tomail(View view) {
        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:"));
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"ayan.chowdhury2050@gmail.com"});
        //i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        //i.putExtra(Intent.EXTRA_TEXT   , "body of email");
        try {
            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            };
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(devack.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void opengit(View view) {
        Intent iweb = new Intent(android.content.Intent.ACTION_VIEW);
        iweb.setData(Uri.parse("https://github.com/GhAc-2017"));
        startActivity(iweb);
    }

    public void oprnst(View view) {
        Intent iweb = new Intent(android.content.Intent.ACTION_VIEW);
        iweb.setData(Uri.parse("https://ghac-2017.github.io/"));
        startActivity(iweb);

    }

    public void openld(View view) {
        Intent iweb = new Intent(android.content.Intent.ACTION_VIEW);
        iweb.setData(Uri.parse("https://www.linkedin.com/in/ayanc-97/"));
        startActivity(iweb);
    }
}

