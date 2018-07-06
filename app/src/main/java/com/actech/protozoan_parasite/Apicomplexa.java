package com.actech.protozoan_parasite;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.LinearGradient;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class Apicomplexa extends AppCompatActivity {

    LinearLayout l1,l2,l3,l4,l5;
    Button rst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apicomplexa);

        l1=findViewById(R.id.l1);
        l2=findViewById(R.id.l2);
        l3=findViewById(R.id.l3);
        l4=findViewById(R.id.l4);
        l5=findViewById(R.id.l5);

        rst=findViewById(R.id.rst);


    }


    public void expand1(View view) {
        l1.setVisibility(View.VISIBLE);
        rst.setVisibility(View.VISIBLE);

    }

    public void expand2(View view) {
        l2.setVisibility(View.VISIBLE);
        rst.setVisibility(View.VISIBLE);
    }
    public void expand3(View view) {
        Toast.makeText(getApplicationContext(),"Nothing to Show Here !!",Toast.LENGTH_SHORT).show();
        rst.setVisibility(View.VISIBLE);
    }
    public void expand4(View view) {
        l3.setVisibility(View.VISIBLE);
        rst.setVisibility(View.VISIBLE);
    }
    public void expand5(View view) {
        l4.setVisibility(View.VISIBLE);
        rst.setVisibility(View.VISIBLE);
    }
    public void expand6(View view) {
        l5.setVisibility(View.VISIBLE);
        rst.setVisibility(View.VISIBLE);
    }

    public void reset(View view) {
        l1.setVisibility(View.GONE);
        l2.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        l4.setVisibility(View.GONE);
        l5.setVisibility(View.GONE);
    }

    public void optioncchose(View view) {

        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("Choose Your Path");
        alertDialog.setMessage("A. Host Wise & B. Genus Wise").setPositiveButton("option B", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent1 =new Intent(getApplicationContext(),popup_layout.class);
                startActivity(intent1);
            }
        }).setNegativeButton("option A", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent1 =new Intent(getApplicationContext(),popup2.class);
                startActivity(intent1);
            }
        });

        AlertDialog alert=alertDialog.create();
        alert.show();
    }

}
