package com.example.ssb.centers;

import android.animation.ArgbEvaluator;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ssb.Adapter;
import com.example.ssb.Info_about_centers;
import com.example.ssb.Model;
import com.example.ssb.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Gandhinagar_Slide extends Activity {
    ViewPager viewPager;
    Adapter adapter;
    TextView name;
    private static final String TAG = "MyActivity";
    Integer[] colors = null;
    String hotel,hotel_detials;
    String center_info, info_details;
    String places, places_info;
    String reach,reach_detail;
    String contact, contact_details;
    List<Model> models;
    CircularImageView maps_open,btn_speech,back;
    TextToSpeech textToSpeech;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    String latitude = "23.281840",longitude = "77.390649";
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide);
        btn_speech = (CircularImageView) findViewById(R.id.audio_btn);
        maps_open = (CircularImageView) findViewById(R.id.maps_button);
        maps_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string =  "http://maps.google.com/maps?q=loc:" + latitude + "," + longitude + "SSB ALLAHABAD";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(string));
                startActivity(intent);

            }
        });

        back = (CircularImageView) findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_back = new Intent(Gandhinagar_Slide.this, Info_about_centers.class);
                startActivity(intent_back);
                Animatoo.animateSwipeRight(Gandhinagar_Slide.this);
                textToSpeech.stop();
            }
        });
        hotel_detials = getResources().getString(R.string.hotels_ahemdabad);
        info_details = getResources().getString(R.string.info_ahemdabad);
        places_info = getResources().getString(R.string.places_ahemdabad);
        reach_detail = getResources().getString(R.string.transport_ahemdabad);
        contact_details = getResources().getString(R.string.contact_ahemdabad);


        hotel = getResources().getString(R.string.hotel_nearby);
        center_info = getResources().getString(R.string.info_about_ssb_center);
        places = getResources().getString(R.string.places_to_visit);
        reach = getResources().getString(R.string.how_to_reach);
        contact = getResources().getString(R.string.contact_name);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.info,center_info,info_details));
        models.add(new Model(R.drawable.train,reach,reach_detail));
        models.add(new Model(R.drawable.hotel_logo,hotel,hotel_detials));
        models.add(new Model(R.drawable.places_to_visit,places,places_info));
        models.add(new Model(R.drawable.contact_logo,contact,contact_details));


        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),
        };

        /* text to speech  */

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int ttsLang = textToSpeech.setLanguage(Locale.US);

                    if (ttsLang == TextToSpeech.LANG_MISSING_DATA
                            || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED);}}}

                );

        colors = colors_temp;
        adapter = new Adapter(models,this);
        viewPager = findViewById(R.id.viewPager_1);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount() - 1) && position < (colors.length - 1))
                {
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset,colors[position],colors[position + 1]));
                }else
                {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
                if (position == 0)
               {
                btn_speech.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int speechStatus = textToSpeech.speak(info_details,TextToSpeech.QUEUE_FLUSH,null);
                    }
                });
               }

               else if (position == 1)
               {
                   btn_speech.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           int speechStatus = textToSpeech.speak(reach_detail,TextToSpeech.QUEUE_FLUSH,null);
               } });
               }
               else if (position == 2)
                {
                    btn_speech.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(hotel_detials,TextToSpeech.QUEUE_FLUSH,null);
                        } });
                }
               else if (position == 3)
                {
                    btn_speech.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(places_info,TextToSpeech.QUEUE_FLUSH,null);

                        } });
                }
               else if (position == 4)
                {
                    btn_speech.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(contact_details,TextToSpeech.QUEUE_FLUSH,null);
                        } });
                }


            }

            @Override
            public void onPageSelected(int position) {
                Log.d(" Tag", ""+ position) ;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
               textToSpeech.stop();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        textToSpeech.stop();
        Animatoo.animateSwipeRight(Gandhinagar_Slide.this);
    }
    @Override
    protected void onUserLeaveHint() {
        textToSpeech.stop();
        super.onUserLeaveHint();
    }
}
