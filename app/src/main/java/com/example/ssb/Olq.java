package com.example.ssb;

import android.animation.ArgbEvaluator;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Olq extends Activity {
    ViewPager viewPager;
Adapter adapter;
Integer[] colors = null;
String ol_1,ol_2,ol_3,ol_4,ol_5,ol_6,ol_7,ol_8,ol_9,ol_10,ol_11,ol_12,ol_13,ol_14,ol_15;
    String desc_1,desc_2,desc_3,desc_4,desc_5,desc_6,desc_7,desc_8,desc_9,desc_10,desc_11,desc_12,desc_13,desc_14,desc_15;
    CircularImageView btn_audio, back;

    List<Model> models;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.what_is_ssb);

        btn_audio = (CircularImageView) findViewById(R.id.audio_btn_1);

        back = (CircularImageView) findViewById(R.id.btn_back_olq);
        back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        Intent intent_back = new Intent(Olq.this, Olq_first_screen.class);
        startActivity(intent_back);
        textToSpeech.stop();    }
        });

       // list of olq and their desription
        ol_1 = getResources().getString(R.string.olq_1);
        ol_2 = getResources().getString(R.string.olq_2);
        ol_3 = getResources().getString(R.string.olq_3);
        ol_4 = getResources().getString(R.string.olq_1);
        ol_5 = getResources().getString(R.string.olq_1);
        ol_6 = getResources().getString(R.string.olq_6);
        ol_7 = getResources().getString(R.string.olq_7);
        ol_8 = getResources().getString(R.string.olq_8);
        ol_9 = getResources().getString(R.string.olq_9);
        ol_10 = getResources().getString(R.string.olq_10);
        ol_11 = getResources().getString(R.string.olq_11);
        ol_12 = getResources().getString(R.string.olq_12);
        ol_13 = getResources().getString(R.string.olq_13);
        ol_14 = getResources().getString(R.string.olq_14);
        ol_15 = getResources().getString(R.string.olq_15);


        desc_1 = getResources().getString(R.string.desc_1);
        desc_2 = getResources().getString(R.string.desc_2);
        desc_3 = getResources().getString(R.string.desc_3);
        desc_4 = getResources().getString(R.string.desc_4);
        desc_5 = getResources().getString(R.string.desc_5);
        desc_6 = getResources().getString(R.string.desc_6);
        desc_7 = getResources().getString(R.string.desc_7);
        desc_8 = getResources().getString(R.string.desc_8);
        desc_9 = getResources().getString(R.string.desc_9);
        desc_10 = getResources().getString(R.string.desc_10);
        desc_11 = getResources().getString(R.string.desc_11);
        desc_12 = getResources().getString(R.string.desc_12);
        desc_13 = getResources().getString(R.string.desc_13);
        desc_14 = getResources().getString(R.string.desc_14);
        desc_15 = getResources().getString(R.string.desc_15);


// text to speech
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int ttsLang = textToSpeech.setLanguage(Locale.US);

                    if (ttsLang == TextToSpeech.LANG_MISSING_DATA
                            || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED);}}}
                            );

models = new ArrayList<>();
        models.add(new Model(R.drawable.intelligence,ol_1,desc_1));
      models.add(new Model(R.drawable.reasoning,ol_2,desc_2));
        models.add(new Model(R.drawable.organizing,ol_3,desc_3));
        models.add(new Model(R.drawable.expressions,ol_4,desc_4));
        models.add(new Model(R.drawable.social,ol_5,desc_5));
        models.add(new Model(R.drawable.cooperation,ol_6,desc_6));
        models.add(new Model(R.drawable.initiative,ol_7,desc_7));
        models.add(new Model(R.drawable.courage,ol_8,desc_8));
        models.add(new Model(R.drawable.determination,ol_9,desc_9));
        models.add(new Model(R.drawable.decision,ol_10,desc_10));
        models.add(new Model(R.drawable.social,ol_11,desc_11));
        models.add(new Model(R.drawable.liveliness,ol_12,desc_12));
        models.add(new Model(R.drawable.determination,ol_13,desc_13));
        models.add(new Model(R.drawable.courage,ol_14,desc_14));
        models.add(new Model(R.drawable.stamina,ol_15,desc_15));




        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),
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
        viewPager.setPadding(130,10,130,10);
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
                            int speechStatus = textToSpeech.speak(desc_1,TextToSpeech.QUEUE_FLUSH,null);

                        }
                    });
                }

                else if (position == 1)
                {
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(desc_2,TextToSpeech.QUEUE_FLUSH,null);

                        } });
                }
                else if (position == 2)
                {
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(desc_3,TextToSpeech.QUEUE_FLUSH,null);
                        } });
                }
                else if (position == 3)
                {
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(desc_4,TextToSpeech.QUEUE_FLUSH,null);

                        } });
                }
                else if (position == 4)
                {
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(desc_5,TextToSpeech.QUEUE_FLUSH,null);
                        } });
                }
                else if (position == 5)
                {
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(desc_6,TextToSpeech.QUEUE_FLUSH,null);
                        } });
                }
                else if (position == 6)
                {
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(desc_7,TextToSpeech.QUEUE_FLUSH,null);
                        } });
                }
                else if (position == 7)
                {
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(desc_8,TextToSpeech.QUEUE_FLUSH,null);
                        } });
                }
                else if (position == 8)
                {
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(desc_9,TextToSpeech.QUEUE_FLUSH,null);
                        } });
                }
                else if (position == 9)
                {
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(desc_10,TextToSpeech.QUEUE_FLUSH,null);
                        } });
                }
                else if (position == 10)
                {
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(desc_11,TextToSpeech.QUEUE_FLUSH,null);
                        } });
                }
                else if (position == 11)
                {
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(desc_12,TextToSpeech.QUEUE_FLUSH,null);
                        } });
                }
                else if (position == 12)
                {
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(desc_13,TextToSpeech.QUEUE_FLUSH,null);
                        } });
                }

                else if (position == 13)
                {
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(desc_14,TextToSpeech.QUEUE_FLUSH,null);
                        } });
                }

                else if (position == 14)
                {
                    btn_audio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int speechStatus = textToSpeech.speak(desc_15 ,TextToSpeech.QUEUE_FLUSH,null);
                        } });
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

    // func. to detect pressing of back button
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        textToSpeech.stop();
        Animatoo.animateSwipeRight(Olq.this);
    }
    // func. to detect whether home button has been pressed
    @Override
    protected void onUserLeaveHint() {
        textToSpeech.stop();
        super.onUserLeaveHint();
    }
}