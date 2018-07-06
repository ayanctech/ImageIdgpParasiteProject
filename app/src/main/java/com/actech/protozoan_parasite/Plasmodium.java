package com.actech.protozoan_parasite;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class Plasmodium extends AppCompatActivity {
    int id;
    String subid,s1="morpho",s2="patho",s3="immuno",s4="lifc";
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static Integer[] XMEN1={R.drawable.plasimm1,R.drawable.plasimm2,R.drawable.plasimm3,R.drawable.plasimm4,R.drawable.plasimm5,R.drawable.plasimm6};

    private static Integer[] XMEN21={R.drawable.sarcopat1,R.drawable.sarcopat2,R.drawable.sarcopat3};
    private static Integer[] XMEN22={R.drawable.sarcolif1,R.drawable.sarcolif2,R.drawable.sarcolif3};

    private static Integer[] XMEN31={R.drawable.toxomorp1,R.drawable.toxomorp2,R.drawable.toxomorp3,R.drawable.toxomorp4};
    private static Integer[] XMEN32={R.drawable.toxopat1,R.drawable.toxopat2,R.drawable.toxopat3,R.drawable.toxopat4,};
    private static Integer[] XMEN33={R.drawable.toxoimm1,R.drawable.toxoimm2,R.drawable.toxoimm3,R.drawable.toxoimm4,R.drawable.toxoimm5,R.drawable.toxoimm6,R.drawable.toxoimm7};

    private static Integer[] XMEN41={R.drawable.leucopath1};
    private static Integer[] XMEN42={R.drawable.leucolif1,R.drawable.leucolif2,R.drawable.leucolif3};

    private static Integer[] XMEN51={R.drawable.besmorph1};
    private static Integer[] XMEN52={R.drawable.bespath1};
    private static Integer[] XMEN53={R.drawable.besidc1};
    private static Integer[] XMEN54={R.drawable.beslif1};

    private static Integer[] XMEN61={R.drawable.heammorph1};
    private static Integer[] XMEN62={R.drawable.heampath1};
    private static Integer[] XMEN63={R.drawable.heamlif1,R.drawable.heamlif2,R.drawable.heamlif3};

    private static Integer[] XMEN71={R.drawable.coccimorp1,R.drawable.coccimorp2};
    private static Integer[] XMEN72={R.drawable.coccipat1,R.drawable.coccipat2,R.drawable.coccipat3,R.drawable.coccipat4,R.drawable.coccipat5,R.drawable.coccipat6,R.drawable.coccipat7,R.drawable.coccipat8,R.drawable.coccipat9,R.drawable.coccipat10,R.drawable.coccipat11,R.drawable.coccipat12};
    private static Integer[] XMEN73={R.drawable.cocciimm1,R.drawable.cocciimm2,R.drawable.cocciimm3,R.drawable.cocciimm4,R.drawable.cocciimm5,R.drawable.cocciimm6};
    private static Integer[] XMEN74={R.drawable.coccilif,R.drawable.coccilif1,R.drawable.coccilif2,R.drawable.coccilif3,R.drawable.coccilif4};

    private static Integer[] XMEN8={R.drawable.bablif1,R.drawable.bablif2,R.drawable.bablif3};

    private static Integer[] XMEN91={R.drawable.theimm1,R.drawable.theimm2,R.drawable.theimm3,R.drawable.theimm4};
    private static Integer[] XMEN92={R.drawable.thelif1,R.drawable.thelif2,R.drawable.thelif3,R.drawable.thelif4,R.drawable.thelif5,R.drawable.thelif6,R.drawable.thelif7};

    private static Integer[] XMEN10={R.drawable.les2,R.drawable.les2po1,R.drawable.les3,R.drawable.les5,R.drawable.les6,R.drawable.les7,R.drawable.les8,R.drawable.les9,R.drawable.les10,R.drawable.les11};

    private static Integer[] XMEN11={R.drawable.trpmor1,R.drawable.trpmor2,R.drawable.trpmor3,R.drawable.trpmor4,R.drawable.trpmor4};

    private static Integer[] XMEN={};
    private static Integer[] XMENzero={};


    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plasmodium);

        Intent intent=getIntent();
        id=intent.getIntExtra("id",0);
        subid=intent.getStringExtra("sub_id");
        //Toast.makeText(getApplicationContext(),"sub ID is "+subid,Toast.LENGTH_SHORT).show();

        if(id==1)
            XMEN=XMEN1;

        else if(id==2) {

            if (subid.equals("patho"))
                XMEN = XMEN21;
            else if (subid.equals("lifc"))
                XMEN = XMEN22;
        }
        else if(id==3) {
            if (subid.equals("morpho"))
                XMEN = XMEN31;
            else if (subid.equals("patho"))
                XMEN = XMEN32;
            else if (subid.equals("immuno"))
                XMEN = XMEN33;
        }
        else if(id==4) {
            if (subid.equals("patho"))
                XMEN = XMEN41;
            else if (subid.equals("lifc"))
                XMEN = XMEN42;
        }
        else if(id==5) {
            if (subid.equals("morpho"))
                XMEN = XMEN51;
            else if (subid.equals("patho"))
                XMEN = XMEN52;
            else if (subid.equals("immuno"))
                XMEN = XMEN53;
            else if (subid.equals("lifc"))
                XMEN = XMEN54;
        }
        else if(id==6) {
            if (subid.equals("morpho"))
                XMEN = XMEN61;
            else if (subid.equals("patho"))
                XMEN = XMEN62;
            else if (subid.equals("lifc"))
                XMEN = XMEN63;
        }
        else if(id==7) {
            if (subid.equals("morpho"))
                XMEN = XMEN71;
            else if (subid.equals("patho"))
                XMEN = XMEN72;
            else if (subid.equals("immuno"))
                XMEN = XMEN73;
            else if (subid.equals("lifc"))
                XMEN = XMEN74;
        }
        else if(id==8)
            XMEN=XMEN8;

        else if(id==9) {
            if (subid.equals("immuno"))
                XMEN = XMEN91;
            else
                XMEN = XMEN92;
        }
        else if(id==10)
            XMEN=XMEN10;

        else
            XMEN=XMEN11;


        init();
    }
    private void init() {

        for(int i=0;i<XMEN.length;i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager) findViewById(R.id.viewpager);
        mPager.setAdapter(new SlidingImage_Adapter(Plasmodium.this,XMENArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 95000, 95000);

        XMEN=XMENzero;
    }
}
