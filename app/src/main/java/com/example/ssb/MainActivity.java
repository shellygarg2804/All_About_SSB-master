package com.example.ssb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.mikhaellopez.circularimageview.CircularImageView;

public class MainActivity extends Activity {
ImageView circularImageView;
Context context;
String size;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        size = checkScreen();

    if (size.equalsIgnoreCase("Small"))
        setContentView(R.layout.activity_main_small);
    else if (size.equalsIgnoreCase("normal"))
        setContentView(R.layout.activity_main);


        circularImageView = findViewById(R.id.logo_edited);

       new Handler().postDelayed(new Runnable() {
       @Override
       public void run() {
        Intent intent = new Intent(MainActivity.this, Activity_2.class);
        startActivity(intent);
        Animatoo.animateSlideUp(MainActivity.this);

       }
   },2500);


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
}}
