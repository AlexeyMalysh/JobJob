package com.program.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class activity_4 extends Activity
//        implements View.OnClickListener
{

    Button rf, drugoe, next4;
    EditText neRus;
    String grajdan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        rf = findViewById(R.id.rf);
        drugoe= findViewById(R.id.drug);
        next4= findViewById(R.id.next4);
        neRus = findViewById(R.id.neRus);
        neRus.setVisibility(View.INVISIBLE);
//        rf.setOnClickListener(this);
//        drugoe.setOnClickListener(this);
//        next4.setOnClickListener(this);





        rf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rf.setBackground(Drawable.createFromPath("ddr"));

                grajdan = "РФ";
                neRus.setVisibility(View.INVISIBLE);
                Log.i("GHJHIKJUH","errrroqweqw");
            }
        });

        neRus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                neRus.setBackground(Drawable.createFromPath("drawable-v24/drugoe.png"));
                neRus.setTextColor(Integer.parseInt("#173FCF"));
                neRus.setVisibility(View.GONE);
                Log.i("GHJHIKJUH","errrro");
            }
        });

        next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(grajdan.equals("")&&neRus.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Заполните все доступные поля", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (neRus.getText().toString().equals("")){
                        Model.getInstance().setNationality(neRus.getText().toString());
                    }
                    else{
                        Model.getInstance().setNationality(grajdan);
                    }

                    showActivity();
                    Log.i("Hhhhhh",Model.getInstance().getNationality());
                }
            }
        });





    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.rf:
//                grajdan = "РФ";
//                v.setPressed(true);
//                break;
//            case R.id.drug:
//                neRus.setVisibility(View.GONE);
//            case R.id.next4:
//                if(grajdan.equals("")||neRus.getText().toString().equals("")){
//                    Toast.makeText(getApplicationContext(), "Заполните все доступные поля", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    if (neRus.getText().toString().equals("")){
//                        Model.getInstance().setNationality(neRus.getText().toString());
//                }
//                else{
//                    Model.getInstance().setNationality(grajdan);
//                    }
//
//                showActivity();
//                    Log.i("Hhhhhh",Model.getInstance().getNationality());
//            }
//        }
//
//    }

    public void showActivity() {
        Intent intent = new Intent(activity_4.this, activity_1.class);
        startActivity(intent);

    }
}
