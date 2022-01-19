package com.program.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_1 extends AppCompatActivity {
    Button next;
    EditText city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);


        next = findViewById(R.id.next);
        city = findViewById(R.id.city);
        Typeface font = Typeface.createFromAsset(getAssets(), "style/my_font.ttf");
        next.setTypeface(font);
        city.setTypeface(font);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityText = city.getText().toString();
                if (cityText.equals("")) {
                    Toast.makeText(getApplicationContext(), "Заполните все необходимые поля", Toast.LENGTH_SHORT).show();
                } else {
                    Model.getInstance().setCity(cityText);
                   showActivity();
                }
            }

        });


    }

    public void showActivity() {
        Intent intent = new Intent(activity_1.this, activity_2.class);
        startActivity(intent);

    }
}