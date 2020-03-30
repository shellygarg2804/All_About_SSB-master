package com.example.ssb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class Olq_first_screen extends Activity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_is__ssb);

       textView = (TextView) findViewById(R.id.more_text);
       textView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(Olq_first_screen.this, Olq.class);
               startActivity(intent);
               Animatoo.animateSwipeLeft(Olq_first_screen.this);
           }
       });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateDiagonal(Olq_first_screen.this);
    }
}
