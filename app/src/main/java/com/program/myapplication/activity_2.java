package com.program.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
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
                if(name.getText().toString().equals("")||surname.getText().toString().equals("")||threename.getText().toString().equals("")){
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