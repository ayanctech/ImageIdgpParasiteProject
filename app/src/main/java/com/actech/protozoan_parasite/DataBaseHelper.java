package com.actech.protozoan_parasite;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by ayanc on 4/9/2018.
 */

/**
 * Created by ayanc on 4/9/2018.
 */

public class DataBaseHelper extends SQLiteAssetHelper {


    private static final int DATABASE_VERSION = 1;

    public DataBaseHelper(Context context,String DATABASE_NAME) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        // you can use an alternate constructor to specify a database location
        // (such as a folder on the sd card)
        // you must ensure that this folder is available and you have permission
        // to write to it
        //super(context, DATABASE_NAME, context.getExternalFilesDir(null).getAbsolutePath(), null, DATABASE_VERSION);

    }


    //******* Methods for Treatment Activity ******

    public List<String> getCgroup(String paraname) {
        List<String> par=new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"C_Group"};
        String sqlTables = "gchem";

        qb.setTables(sqlTables);
        String [] args={paraname};
        Cursor c = qb.query(db, sqlSelect, "Gns_Name=?", args,
                null, null, null);

        c.moveToFirst();
        while (!c.isAfterLast()) {
            par.add(c.getString(0));
            c.moveToNext();
        }
        c.close();
        db.close();

        return  par;
    }

    public  HashMap<String,List<TProperties>> getCgroupList(String paraname) {

        HashMap<String,List<TProperties>> tlist= new HashMap<>();

        List<String> anm=new ArrayList<>();
        List<String> anm2=new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"C_Group","C_Field"};
        String sqlTables = "gchem";

        qb.setTables(sqlTables);
        String [] args={paraname};
        Cursor c = qb.query(db, sqlSelect, "Gns_Name=?", args,
                null, null, null);

        c.moveToFirst();
        while (!c.isAfterLast()) {
            String strindex=c.getString(0);
            List<TProperties> tpr = new ArrayList<>();
            anm.add(strindex);
            anm2.add(c.getString(1));

            c.moveToNext();
        }
        c.close();


        for(int i=0;i<anm2.size();i++) {
            List<TProperties> tpr = new ArrayList<>();
            String[] sqlSelect1 = {"G_Name", "Dose", "B_Name", "Char", "C_Field"};
            String sqlTables1 = "gchar";

            qb.setTables(sqlTables1);
            String[] args2 = {anm2.get(i)};
            Cursor c2 = qb.query(db, sqlSelect1, "C_Field=?", args2,
                    null, null, null);
            c2.moveToFirst();
            while (!c2.isAfterLast()){
                TProperties tp=new TProperties(c2.getString(0),c2.getString(1),c2.getString(2),c2.getString(3));
                tpr.add(tp);
                c2.moveToNext();
            }

            tlist.put(anm.get(i),tpr);
            c2.close();

        }
        db.close();

        return tlist;
    }


    //$$$ METHODS For HostParasite Database $$$$
    public List<String> getAnmName() {
        List<String> par=new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"name_animal"};
        String sqlTables = "main";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null,null,
                null, null, null);

        c.moveToFirst();
        while (!c.isAfterLast()) {
            par.add(c.getString(0));
            c.moveToNext();
        }
        c.close();
        db.close();

        return  par;
    }
    public List<String> getParName() {
        List<String> par=new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"name_parasite"};
        String sqlTables = "main1";

        qb.setTables(sqlTables);

        Cursor c = qb.query(db, sqlSelect, null,null,
                null, null, null);

        c.moveToFirst();
        while (!c.isAfterLast()) {
            par.add(c.getString(0));
            c.moveToNext();
        }
        c.close();
        db.close();

        return  par;
    }
    public List<String> getorgan() {
        List<String> par=new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"organ"};
        String sqlTables = "main2";

        qb.setTables(sqlTables);

        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
        while (!c.isAfterLast()) {
            par.add(c.getString(0));
            c.moveToNext();
        }
        c.close();
        db.close();

        return  par;
    }

    public List<HostPar> getHostpar(String anmname,String orgn) {
        List<HostPar> par=new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"name_animal","organ","type_parasite","name_parasite"};
        String sqlTables = "details";

        qb.setTables(sqlTables);
        String [] args={anmname,orgn};

            Cursor c = qb.query(db, sqlSelect, "name_animal=? and organ=?", args,
                    null, null, null);
            c.moveToFirst();

        while (!c.isAfterLast()) {
            HostPar hpar=new HostPar(c.getString(0),c.getString(1),c.getString(2),c.getString(3));
            par.add(hpar);
            c.moveToNext();
        }
        c.close();
        db.close();

        return  par;
    }



   //$$$$$ Methods for ScientificName Acttivity $$$$$$
    public List<String> getAnimalList() {
        List<String> anm=new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"name"};
        String sqlTables = "details";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, "name ASC");

        c.moveToFirst();
        while (!c.isAfterLast()) {
            anm.add(c.getString(0));
            c.moveToNext();
        }
        c.close();
        db.close();

        return anm;

    }

    public String getSnam(String nam) {
        String scn="";
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();


        String [] sqlSelect = {"scname"};
        String sqlTables = "details";

        qb.setTables(sqlTables);
        //Cursor c = qb.query(db, sqlSelect, null, null,null, null, null);
        String [] args={nam};
        Cursor c=qb.query(db,sqlSelect,"name=?",args,null, null, null);
        c.moveToFirst();
        scn=c.getString(0);

        c.close();
        db.close();

        return scn;
    }


}