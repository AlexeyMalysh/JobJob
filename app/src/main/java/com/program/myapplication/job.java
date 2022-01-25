package com.program.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class job extends AppCompatActivity {
   static ArrayList<JobModel> states = new ArrayList<JobModel>();
    Button profile;
    ListView countriesList;
    ModelData modelData;
    private static final String JSON_URL = "http://65.108.86.158/offers";
    @Override
    protected void onCreate(Bundle savedInstanceJob) {

        super.onCreate(savedInstanceJob);
        setContentView(R.layout.activity_job);

        // начальная инициализация списка
        setInitialData();
        Log.e("VACANCY", ActivityOkHttp.getVacancy());
        Log.e("VACANCY", String.valueOf(ActivityOkHttp.getId()));



        // получаем элемент ListView
        countriesList = findViewById(R.id.countriesList);
        profile = findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(job.this, profile.class);
                startActivity(intent);
            }
        });
        // создаем адаптер
        JobAdapter stateAdapter = new JobAdapter(this, R.layout.list_item, states);
        // устанавливаем адаптер
        countriesList.setAdapter(stateAdapter);
        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                JobModel selectedJob = (JobModel)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedJob.getCompany(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        countriesList.setOnItemClickListener(itemListener);
    }
    private void setInitialData(){
        try {
            JSONObject jsonObj = new JSONObject(ActivityOkHttp.getVacancy());
            JSONArray contacts = jsonObj.getJSONArray("offers");
            for (int i = 0; i < contacts.length(); i++) {
                JSONObject c = contacts.getJSONObject(i);

                int id = c.getInt("id");
                String city = c.getString("city");
                String company = c.getString("company");
                String info = c.getString("info");
                String sale = c.getString("sale");
                String job_time = c.getString("job_time");
                String vacancy = c.getString("vacancy");
                String urlImage = c.getString("url_image");

                Log.e("Watch", id+city+company+info+sale);
                states.add(new JobModel(id,company,info,sale,job_time,vacancy,urlImage));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }




    }
