package com.program.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.IOException;

public class activity_4 extends Activity
//        implements View.OnClickListener
{

    Button rf, drugoe, next4;
    EditText neRus;
    String grajdan="";

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


        InputFilter filter = new InputFilter() {
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                for (int i = start; i < end; i++) {
                    if (!Character.isLetter(source.charAt(i))&&!Character.isSpaceChar(source.charAt(i))) {
                        return "";
                    }
                }
                return null;
            }
        };

        neRus.setFilters(new InputFilter[] { filter });


        rf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               rf.setBackgroundResource(R.drawable.drugoe);
               drugoe.setBackgroundResource(R.drawable.russ);

                grajdan = "РФ";
                neRus.setVisibility(View.INVISIBLE);
                Log.i("GHJHIKJUH","errrroqweqw");
            }
        });

        drugoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               drugoe.setBackgroundResource(R.drawable.drugoe);
                rf.setBackgroundResource(R.drawable.russ);
                neRus.setVisibility(View.VISIBLE);
                Log.i("GHJHIKJUH","errrro");
            }
        });

        next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(neRus.getVisibility()==View.VISIBLE){
                    Log.i("Ddddddd",neRus.getText().toString() );

                    if(neRus.getText()==null||neRus.getText().toString().equals("")){
                        neRus.setBackgroundResource(R.drawable.error);
                        Toast.makeText(getApplicationContext(), "Заполните все доступные поля", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Model.getInstance().setNationality(neRus.getText().toString());
                        Intent intent = new Intent(activity_4.this, activity_5.class);
                        startActivity(intent);
                        Log.i("Hhhhhh",Model.getInstance().getNationality());
                    }
                }
                else if(neRus.getVisibility()==View.INVISIBLE){
                    if(grajdan.equals("")||!grajdan.equals("РФ"))
                        Toast.makeText(getApplicationContext(), "Заполните все доступные поля", Toast.LENGTH_SHORT).show();
                    else
                        Model.getInstance().setNationality(grajdan);
                    Intent intent = new Intent(activity_4.this, activity_5.class);
                    startActivity(intent);

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


}
