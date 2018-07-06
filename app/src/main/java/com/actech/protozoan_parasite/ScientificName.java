package com.actech.protozoan_parasite;

import android.database.Cursor;
import android.database.SQLException;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;

import java.io.IOException;
import java.util.List;

public class ScientificName extends AppCompatActivity {

    private List<String> animals;
    DataBaseHelper myDbHelper;
    String nam="Opossum",scnam;
    private static final String DATABASE_NAME = "sname.sqlite";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific_name);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myDbHelper = new DataBaseHelper(this,DATABASE_NAME);
       // myDbHelper = new DataBaseHelper(this);

        animals=myDbHelper.getAnimalList();

        MaterialSpinner spinner = (MaterialSpinner) findViewById(R.id.nmspn);
        spinner.setDropdownHeight(1000);
        //spinner.setItems("Bovine", "Buffalo", "Cammel & Llama", "Dog,Cat & Fox", "Duck","Fowl","Goose","Horse","Man","Pig","Rodent","Rodent and Lagomorphs","Sheep & Goat");
        spinner.setItems(animals);
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                nam=item;
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });

    /*
        try {

            myDbHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        try {

            myDbHelper.openDataBase();
            Toast.makeText(getApplicationContext(),"Database connection success",Toast.LENGTH_SHORT).show();



        }catch(SQLException sqle){

            throw sqle;

        }
        */
    }

    public void go(View view) {
        TextView snam=findViewById(R.id.snam);
        snam.setText(myDbHelper.getSnam(nam));

    }

}
