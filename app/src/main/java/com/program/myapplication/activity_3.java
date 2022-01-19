package com.program.myapplication;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.sapereaude.maskedEditText.MaskedEditText;

public class activity_3
        extends Activity {

    MaskedEditText tvDate;
    Button next;

    /** Called when the activity is first created. */

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        tvDate = findViewById(R.id.date_input);
        next = findViewById(R.id.next3);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvDate.getRawText().equals("")){
                    Toast.makeText(getApplicationContext(), "Заполните все доступные поля", Toast.LENGTH_SHORT).show();
                }

                else {
                    Model.getInstance().setDateBirth(tvDate.getText().toString());
                    Log.i("GGGGGGGG", tvDate.getText().toString());
                    showActivity();
                }
            }
        });

    }

    public void showActivity() {
        Intent intent = new Intent(activity_3.this, activity_4.class);
        startActivity(intent);

    }



}