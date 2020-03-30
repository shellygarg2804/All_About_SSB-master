package com.example.ssb;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ssb.centers.Bangalore_Slide;
import com.example.ssb.centers.Dehradun_Slide;
import com.example.ssb.centers.Allahabad_Slide;
import com.example.ssb.centers.Bhopal_Slide;
import com.example.ssb.centers.Coiambatore_Slide;
import com.example.ssb.centers.Gandhinagar_Slide;
import com.example.ssb.centers.Mysore_Slide;
import com.example.ssb.centers.Kapurthala_slide;
import com.example.ssb.centers.Varanasi_Slide;
import com.google.android.gms.ads.InterstitialAd;

public class Info_about_centers extends Activity {

ImageView logo;
ImageView logo_punjab, logo_allahabd,logo_bhopal,bangalore_img;
ImageView bhopal_navy, bangalore_navy;
ImageView logo_dehradun, logo_mysore, logo_gandhinagar, logo_varanasi,logo_coiambatore,logo_vishakhapatnam;
ImageView punjab_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_about_centers);

        //logo
        logo = (ImageView) findViewById(R.id.logo_new) ;
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Info_about_centers.this,"For detials open Contact Us on Home Screen",Toast.LENGTH_LONG).show();

            }
        });
        // SCN KAPURTHALA
        logo_punjab = (ImageView) findViewById(R.id.logo_new);
        punjab_image = (ImageView) findViewById(R.id.punjab_logo);
        punjab_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Info_about_centers.this, Kapurthala_slide.class);
                startActivity(intent);
                Animatoo.animateZoom(Info_about_centers.this);
            }
        });
          // ALLAHABAD
        logo_allahabd = (ImageView) findViewById(R.id.allahabad_logo);
        logo_allahabd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent allahabad = new Intent(Info_about_centers.this, Allahabad_Slide.class);
                startActivity(allahabad);
                Animatoo.animateZoom(Info_about_centers.this);
            }
        });
         // BHOPAL
        logo_bhopal = (ImageView) findViewById(R.id.Bhopal_logo);
         logo_bhopal.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent bhopal = new Intent(Info_about_centers.this, Bhopal_Slide.class);
                 startActivity(bhopal);
                 Animatoo.animateZoom(Info_about_centers.this);
             }
         });
          // BANGALORE
         bangalore_img = (ImageView) findViewById(R.id.bangalore_logo);
         bangalore_img.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent bangalore = new Intent(Info_about_centers.this, Bangalore_Slide.class);
                 startActivity(bangalore);
                 Animatoo.animateZoom(Info_about_centers.this);
             }
         });

         // DEHRADUN
        logo_dehradun = (ImageView) findViewById(R.id.dehradun);
        logo_dehradun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent Dehradun = new Intent(Info_about_centers.this, Dehradun_Slide.class);
              startActivity(Dehradun);
                Animatoo.animateZoom(Info_about_centers.this);
            }
        });

        logo_mysore = (ImageView) findViewById(R.id.mysore);
        logo_mysore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mysore = new Intent(Info_about_centers.this, Mysore_Slide.class);
                startActivity(mysore);
                Animatoo.animateZoom(Info_about_centers.this);
            }
        });

        logo_gandhinagar = (ImageView) findViewById(R.id.gandhi_nagar);
        logo_gandhinagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gandhinagar = new Intent(Info_about_centers.this, Gandhinagar_Slide.class);
                startActivity(gandhinagar);
                Animatoo.animateZoom(Info_about_centers.this);
            }
        });

        logo_varanasi = (ImageView) findViewById(R.id.vanarasi);
        logo_varanasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent varanasi = new Intent(Info_about_centers.this, Varanasi_Slide.class);
                startActivity(varanasi);
                Animatoo.animateZoom(Info_about_centers.this);
            }
        });

        logo_coiambatore =  (ImageView) findViewById(R.id.coimbatore);
        logo_coiambatore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent coiambatore = new Intent(Info_about_centers.this, Coiambatore_Slide.class);
                startActivity(coiambatore);
                Animatoo.animateZoom(Info_about_centers.this);
            }
        });

        bangalore_navy = (ImageView) findViewById(R.id.bangalore_navy);
        bangalore_navy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bangalore = new Intent(Info_about_centers.this, Bangalore_Slide.class);
                startActivity(bangalore);
                Animatoo.animateZoom(Info_about_centers.this);
            }
        });

        bhopal_navy = (ImageView) findViewById(R.id.Bhopal_navy);
        bhopal_navy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Info_about_centers.this, Bhopal_Slide.class);
                startActivity(intent);
                Animatoo.animateZoom(Info_about_centers.this);
            }
        });

        logo_vishakhapatnam = (ImageView) findViewById(R.id.vishakapatnam);
        logo_vishakhapatnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Info_about_centers.this,"Under Development",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateZoom(Info_about_centers.this);
    }
}




