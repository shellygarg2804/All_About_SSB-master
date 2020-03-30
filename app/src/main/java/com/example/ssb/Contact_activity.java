package com.example.ssb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import static android.widget.Toast.LENGTH_SHORT;

public class Contact_activity extends AppCompatActivity {
ImageView insta, gmail;
Button ad;
    Uri uri = Uri.parse("https://www.instagram.com/mishra_abhishek_24/");
    Intent instagram  = new Intent(Intent.ACTION_VIEW, uri);
Window window;
 private InterstitialAd m_interstitialAd;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_contact_activity);
        instagram.setPackage("com.instagram.android");

        //ad
        m_interstitialAd = new InterstitialAd(this);
        m_interstitialAd.setAdUnitId("ca-app-pub-9684827030039892/9756368034");
        m_interstitialAd.loadAd(new AdRequest.Builder().build());

        if (m_interstitialAd.isLoaded()){
                    m_interstitialAd.show();
                }
                else
                    Log.d("TAG","not loaded yet");

        gmail = (ImageView) findViewById(R.id.gmail_image);
        insta = (ImageView) findViewById(R.id.insta_image);


        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mishra695047@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Support for All About SSB");
                intent.setPackage("com.google.android.gm");
                if (intent.resolveActivity(getPackageManager())!=null)
                    startActivity(intent);

            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(instagram);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com/mishra_abhishek_24/")));
                }
            }
        });
}

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideLeft(Contact_activity.this);
    }
}
