package com.actech.protozoan_parasite;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;

public class popup2 extends AppCompatActivity {
    String nam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup2);

        MaterialSpinner msp=findViewById(R.id.spn);
        msp.setItems("Ship and Goat","Cattle","Swine","Horse","Rabbit","Domestic Fowl","Mouse");
        msp.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                nam=item;
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });

    }

    public void ok(View view) {
        Toast.makeText(getApplicationContext(),"Coming soon..",Toast.LENGTH_SHORT).show();
    }
}
