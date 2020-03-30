package com.example.ssb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDelegate;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Activity_2 extends Activity {
 LinearLayout layout1,layout2,layout3,layout4;
 TextView view1,view2,view3,view4;
 ImageView logo,Image1,Image2,Image3,Image4;
 AdView m_adview;
 String size;
    @Override

    //to do change

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        size = checkScreen();

        if (size.equalsIgnoreCase("Small"))
            setContentView(R.layout.activity_2_small);
        else if (size.equalsIgnoreCase("normal"))
            setContentView(R.layout.activity_2);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
           @Override
           public void onInitializationComplete(InitializationStatus initializationStatus) {

           }
       });


       m_adview = findViewById(R.id.adView);
       AdRequest adRequest = new AdRequest.Builder().build();
       m_adview.loadAd(adRequest);

        //layout's
        layout1 = (LinearLayout) findViewById(R.id.linearlayout_1_large);
        layout2 = (LinearLayout) findViewById(R.id.linearlayout_2_large);
        layout3 = (LinearLayout) findViewById(R.id.linearlayout_3_large);
        layout4 = (LinearLayout) findViewById(R.id.linearlayout_4_large);

        logo = (ImageView) findViewById(R.id.logo_info);
        view1 = (TextView) findViewById(R.id.text_1);
        view2 = (TextView) findViewById(R.id.schedule);
       view3 = (TextView) findViewById(R.id.infoaboutcenter);


       layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Activity_2.this,"Opening What's SSB",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Activity_2.this, Olq_first_screen.class);
                startActivity(intent);
                Animatoo.animateDiagonal(Activity_2.this);
            }
        });

        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Activity_2.this,"Opening Schedule",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Activity_2.this,Ssb_details.class);
                startActivity(intent);
                Animatoo.animateZoom(Activity_2.this);
            }
        });

        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Activity_2.this,"Opening Info About Centers",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Activity_2.this, Info_about_centers.class);
                startActivity(intent);
                Animatoo.animateSwipeRight(Activity_2.this);
            }
        });

        layout4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(Activity_2.this,"Opening Contact us",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Activity_2.this, Contact_activity.class);
            startActivity(intent);
            Animatoo.animateSwipeLeft(Activity_2.this);
        }
    });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideLeft(Activity_2.this);
    }

    public String checkScreen(){

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        String screenSize = null;
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        int dens = dm.densityDpi;
        double wi = (double)width / (double)dens;
        double hi = (double)height / (double)dens;
        double x = Math.pow(wi, 2);
        double y = Math.pow(hi, 2);
        double screenInches = Math.sqrt(x+y);

        if (screenInches <= 5.2)
            screenSize = "small";
        else if (screenInches > 5.2 && screenInches < 6.5)
            screenSize = "normal";

        return screenSize;
    }



}