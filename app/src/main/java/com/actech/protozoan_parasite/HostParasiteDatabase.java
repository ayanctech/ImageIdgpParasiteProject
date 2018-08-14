package com.actech.protozoan_parasite;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.flipboard.bottomsheet.commons.IntentPickerSheetView;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;
import java.util.List;

public class HostParasiteDatabase extends AppCompatActivity {
    String nam="",orgn="",nampar="";
    ListView lvw;
    private static final String DATABASE_NAME = "hostparasite.sqlite";
    DataBaseHelper mydbhelper;
    List<HostPar> hp;
    HostParListAdap hladp;
    MaterialSpinner spinner,spinner2,spinner3;
    BottomSheetLayout bottomSheet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_parasite_database);

        bottomSheet = (BottomSheetLayout) findViewById(R.id.bottomsheet);

        lvw=findViewById(R.id.listview_hostpar);

        mydbhelper=new DataBaseHelper(this,DATABASE_NAME);

        spinner =findViewById(R.id.nmspn);
        spinner2 =findViewById(R.id.orgspn);
        spinner3 =findViewById(R.id.parspn);

        spinner.setDropdownHeight(1000);spinner2.setDropdownHeight(1000);spinner3.setDropdownHeight(1000);

        spinner.setItems(mydbhelper.getAnmName());spinner2.setItems(mydbhelper.getorgan());spinner3.setItems(mydbhelper.getParName());
        rst();

       // spinner.setItems("Bovine", "Buffalo", "Cammel & Llama", "Dog,Cat & Fox", "Duck","Fowl","Goose","Horse","Man","Pig","Rodent","Rodent and Lagomorphs","Sheep & Goat");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                nam=item;
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });
        spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                orgn=item;
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });
        spinner3.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                nampar=item;
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });



    }

    private void rst() {
        spinner.setText("Choose Animal Name");
        spinner2.setText("Choose Organ");
        spinner3.setText("Choose Parasite Name");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menuinfo, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_name) {
            new MyFragment().show(getSupportFragmentManager(), R.id.bottomsheet);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void gofetch(View view) {
        if(nam=="Choose Animal Name" || orgn=="Choose Organ"){
            Toast.makeText(getApplicationContext(),"Please choose a valid entry ",Toast.LENGTH_SHORT).show();
        }
        else {
            hp = mydbhelper.getHostpar(nam, orgn);
            hladp = new HostParListAdap(this, hp);
            lvw.setAdapter(hladp);
        }

    }

    public void reset(View view) {
        rst();
    }
}
