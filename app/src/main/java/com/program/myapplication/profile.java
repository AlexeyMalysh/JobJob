package com.program.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profile extends AppCompatActivity {
    TextView city, name, datB, nationality, email, phoneNumber;
    Button earlier;
    ModelData modelData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);
        city = findViewById(R.id.city);
        name = findViewById(R.id.name);
        datB = findViewById(R.id.dateBith);
        nationality = findViewById(R.id.nationality);
        email = findViewById(R.id.email);
        phoneNumber = findViewById(R.id.phone);
        earlier = findViewById(R.id.earlier);

        modelData = new ModelData(this);
        modelData.getModel();
        city.setText(Model.getInstance().getCity());
        String fullName = Model.getInstance().getLastname()+" "+Model.getInstance().getName()+" " +Model.getInstance().getOtch();
        name.setText(fullName);

      datB.setText(Model.getInstance().getDateBirth());
        nationality.setText(Model.getInstance().getNationality());
        email.setText(Model.getInstance().getEmail());
        phoneNumber.setText(Model.getInstance().getPhoneNumber());

        earlier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, job.class);
                startActivity(intent);
                finish();
            }
        });


    }
}