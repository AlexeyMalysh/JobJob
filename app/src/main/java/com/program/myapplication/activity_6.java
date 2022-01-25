package com.program.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.sapereaude.maskedEditText.MaskedEditText;

public class activity_6 extends Activity {
    MaskedEditText phone;
    Button next;
    Model model  = Model.getInstance();

    public static  ModelData modelData;

    /** Called when the activity is first created. */

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
        phone = findViewById(R.id.phone_input);
        next = findViewById(R.id.next6);

        modelData = new ModelData(this);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(phone.getRawText().length() ==10)){
                    phone.setBackgroundResource(R.drawable.error);
                    Toast.makeText(getApplicationContext(), "Заполните все доступные поля корректно", Toast.LENGTH_SHORT).show();
                }

                else {
                    Model.getInstance().setPhoneNumber(phone.getText().toString());
                    Log.i("GGGGGGGG", phone.getText().toString());
                    showActivity();

                }
                try {
                    buildJson();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                modelData.insertPerson( model.getCity(),model.getName(),model.getLastname(),model.getOtch()
                        ,model.getDateBirth(),model.getNationality(),model.getEmail(),model.getPhoneNumber());

                Log.e("wqdjdq", String.valueOf(ActivityOkHttp.getId()));


            }
        });

    }


    public void buildJson() throws JSONException {

        String js = new JSONObject()

                .put("name", model.getName())
                .put("surname", model.getLastname())
                .put("threename", model.getOtch())
                .put("dateBirth", model.getDateBirth())
                .put("nationality", model.getNationality())
                .put("email", model.getEmail())
                .put("phone", model.getPhoneNumber())
                .toString();


        ActivityOkHttp activityOkHttp = new ActivityOkHttp();
        activityOkHttp.postHttpEmployer(js);
    }






    public void showActivity() {
        Intent intent = new Intent(activity_6.this, job.class);
        startActivity(intent);

    }



}

