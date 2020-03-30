package com.example.ssb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Ssb_details extends Activity {
    ViewPager viewPager;
    Adapter adapter;
    Integer[] colors = null;
    CircularImageView btn_audio, back;

    List<Model> models;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    TextToSpeech textToSpeech;

    String first, second, third, fourth, fifth;
    // details
    String day_1, day_2, day_3, day_4, day_5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.what_is_ssb);

        btn_audio = (CircularImageView) findViewById(R.id.audio_btn_1);

        back = (CircularImageView) findViewById(R.id.btn_back_olq);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_back = new Intent(Ssb_details.this, Activity_2.class);
                startActivity(intent_back);
                Animatoo.animateSwipeRight(Ssb_details.this);
                textToSpeech.stop();    }
        });

        first = getResources().getString(R.string.first_day);
        second = getResources().getString(R.string.second_day);
        third = getResources().getString(R.string.third_day);
        fourth = getResources().getString(R.string.fourth_day);
        fifth = getResources().getString(R.string.fifth_day);

        day_1 = getResources().getString(R.string.info_first);
        day_2 = getResources().getString(R.string.info_second);
        day_3 = getResources().getString(R.string.info_third);
        day_4 = getResources().getString(R.string.info_fourth);
        day_5 = getResources().getString(R.string.info_fifth);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int ttsLang = textToSpeech.setLanguage(Locale.US);

                    if (ttsLang == TextToSpeech.LANG_MISSING_DATA
                            || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED);}}}
        );

        models = new ArrayList<>();
        models.add(new Model(R.drawable.day_1_image,first,day_1));
        models.add(new Model(R.drawable.day_2,second,day_2));
        models.add(new Model(R.drawable.strength,third,day_3));
        models.add(new Model(R.drawable.day_3,fourth,day_4));
        models.add(new Model(R.drawable.day_5,fifth,day_5));


        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),
        };

        colors = colors_temp;
        adapter = new Adapter(models,this);
        viewPager = findViewById(R.id.viewPager_3);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(120,10,120,10);
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
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(day_1,TextToSpeech.QUEUE_FLUSH,null);

                        }
                    });
                }
                if (position == 1)
                {
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(day_2,TextToSpeech.QUEUE_FLUSH,null);
                        }
                    });
                }
                if (position == 2)
                {
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(day_3,TextToSpeech.QUEUE_FLUSH,null);
                        }
                    });
                }
                if (position == 3)
                {
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(day_4,TextToSpeech.QUEUE_FLUSH,null);
                        }
                    });
                }

                if (position == 4)
                {
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(day_5,TextToSpeech.QUEUE_FLUSH,null);
                        }
                    });
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                   textToSpeech.stop();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        textToSpeech.stop();
        Animatoo.animateSlideRight(Ssb_details.this);
    }

    @Override
    protected void onUserLeaveHint() {
        textToSpeech.stop();
        super.onUserLeaveHint();
    }
}
