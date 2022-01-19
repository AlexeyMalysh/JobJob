package com.program.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class start extends AppCompatActivity {
 Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        button = findViewById(R.id.start);
        Typeface font = Typeface.createFromAsset(getAssets(), "style/my_font.ttf");
        button.setTypeface(font);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showActivity();
            }
        });

    }

    public  void showActivity(){
        Intent intent = new Intent(start.this,activity_1.class);
        startActivity(intent);
        this.finish();


    }
}