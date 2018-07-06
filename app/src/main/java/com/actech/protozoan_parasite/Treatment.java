package com.actech.protozoan_parasite;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Treatment extends AppCompatActivity {
    private static final String DATABASE_NAME = "treatment.sqlite";
    DataBaseHelper myDbHelper;
    ExpandableListView elvw;
    List<String> para_list;
    ListAdap ladp;
    ExpandableListAdapter eladp;
    List<String> listDataHeader;
    HashMap<String, List<TProperties>> listDataChild;

    String paraname="BABESIA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        elvw=findViewById(R.id.listview_cgroup);

        MaterialSpinner spinner = (MaterialSpinner) findViewById(R.id.nmspn);
        spinner.setItems("BABESIA","COCCIDIA","HEXAMITA","HISTOMONAS","LEISHMANIA","THEILERIA","TOXOPLASMA","TRICHOMONAS","TRYPANOSOMA");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                paraname=item;
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });

        myDbHelper = new DataBaseHelper(this,DATABASE_NAME);


        // Listview Group expanded listener
        elvw.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        elvw.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        elvw.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
        
    }


    public void go(View view) {
     /*   para_list=myDbHelper.getCgroupList(paraname.toLowerCase());
        //Init adapter
        ladp = new ListAdap(this, para_list);
        //Set adapter for listview
        elvw.setAdapter(ladp);
    */
    listDataHeader = new ArrayList<>();
    listDataHeader=myDbHelper.getCgroup(paraname.toLowerCase());
    listDataChild = new HashMap<>();
    listDataChild=myDbHelper.getCgroupList(paraname.toLowerCase());
    eladp=new ExpandableListAdapter(this,listDataHeader,listDataChild);
    elvw.setAdapter(eladp);
    }
}
