package com.program.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.q42.android.scrollingimageview.ScrollingImageView;

public class MainActivity extends AppCompatActivity {
    ModelData modelData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        modelData = new ModelData(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityOkHttp activityOkHttp = new ActivityOkHttp();
        activityOkHttp.getZ();
        Handler handler = new Handler();
        ScrollingImageView scrollingBackground = (ScrollingImageView) findViewById(R.id.scrolling_background);
//        scrollingBackground.setScaleY(0.64f);


            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!(modelData.getPhoneNumber().getCount() >0)) {
                        Intent intent = new Intent(MainActivity.this, start.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Intent intent = new Intent(MainActivity.this, job.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }, 3000);
        }

    }

