package com.program.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {
    ModelData modelData;
    Button go, rr;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        modelData = new ModelData(this);

        go = findViewById(R.id.gooo);
        result = findViewById(R.id.resultt);
        rr = findViewById(R.id.rr);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               modelData.getModel();
              if(modelData.getPhoneNumber().getCount()>0) {

                  String resultString = Model.getInstance().getCity() + Model.getInstance().getDateBirth() + Model.getInstance().getEmail()
                          + Model.getInstance().getName() + Model.getInstance().getPhoneNumber();
                  result.setText(resultString);
              }
            }
        });

        rr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.program.myapplication.result.this, job.class);
                startActivity(intent);
            }
        });



    }
}