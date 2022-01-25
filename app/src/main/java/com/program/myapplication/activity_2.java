package com.program.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_2 extends AppCompatActivity {
    EditText name, surname, threename;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        threename = findViewById(R.id.threename);

        next = findViewById(R.id.next);
        Typeface font = Typeface.createFromAsset(getAssets(), "style/my_font.ttf");
        next.setTypeface(font);




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namm = name.getText().toString();
                String surnamm = surname.getText().toString();
                String threnamm = threename.getText().toString();
                if(namm.equals("")||surnamm.equals("")||threnamm.equals("")
                    |!namm.matches("[а-яА-Я ]+")||!surnamm.matches("[а-яА-Я ]+")||!threnamm.matches("[а-яА-Я ]+")){
                    if(name.getText().toString().equals("")||!namm.matches("[а-яА-Я ]+")){
                        name.setBackgroundResource(R.drawable.error);
                    }
                    if(surname.getText().toString().equals("")||!surnamm.matches("[а-яА-Я ]+")){
                        surname.setBackgroundResource(R.drawable.error);
                    }
                    if(threename.getText().toString().equals("")||!threnamm.matches("[а-яА-Я ]+")){
                        threename.setBackgroundResource(R.drawable.error);
                    }
                    Toast.makeText(getApplicationContext(), "Заполните все доступные поля", Toast.LENGTH_SHORT).show();
                }
                else{
                    Model.getInstance().setName(name.getText().toString());
                    Model.getInstance().setLastname(surname.getText().toString());
                    Model.getInstance().setOtch(threename.getText().toString());
                    showActivity();
                }
            }
        });
    }
    public void showActivity() {
        Intent intent = new Intent(activity_2.this, activity_3.class);
        startActivity(intent);

    }
}