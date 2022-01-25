package com.program.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
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

//        InputFilter filter = new InputFilter() {
//            public CharSequence filter(CharSequence source, int start, int end,
//                                       Spanned dest, int dstart, int dend) {
//                for (int i = start; i < end; i++) {
//                    if (!Character.isLetter(source.charAt(i))&&!Character.isSpaceChar(source.charAt(i))) {
//                        return "";
//                    }
//                }
//                return null;
//            }
//        };
//        city.setFilters(new InputFilter[] { filter });

//        city.setFilters(new InputFilter[] {
//                new InputFilter() {
//                    @Override
//                    public CharSequence filter(CharSequence source, int start,
//                                               int end, Spanned dest, int dstart, int dend) {
//                        if(source.equals("")){ // for backspace
//                            return source;
//                        }
//                        if(source.toString().matches("[a-zA-Zа-яА-Я]+")){
//                            return source;
//                        }
//                        return "";
//                    }
//                }
//        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityText = city.getText().toString();
                if (!cityText.matches("[а-яА-Я ]+")) {
                    city.setBackgroundResource(R.drawable.error);
                    Toast.makeText(getApplicationContext(), "Заполните все необходимые поля кореектно", Toast.LENGTH_SHORT).show();
                } else {
                    Model.getInstance().setCity(cityText);
                    Log.e("ewqd", Model.getInstance().getCity());
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