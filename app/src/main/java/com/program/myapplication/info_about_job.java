package com.program.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class info_about_job extends AppCompatActivity {
    TextView company, vacancy, sale,time;
    ImageView image;
    Button go;
    JobModel jobModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_about_job);
        company = findViewById(R.id.companyName);
        vacancy = findViewById(R.id.vacancyName);
        sale = findViewById(R.id.job_sale_info);
        time = findViewById(R.id.job_time_info);

        image = findViewById(R.id.image_company);
        go = findViewById(R.id.go_off);
        Intent intent = getIntent();

        int id = Integer.parseInt(intent.getStringExtra("id"));

        for (int i = 0; i < job.states.size(); i++) {
            if(job.states.get(i).idVacancy==id){
                jobModel= job.states.get(i);
            }
        }
        company.setText(jobModel.getCompany());
        vacancy.setText(jobModel.getVacancy());
        sale.setText(jobModel.getSale());
        time.setText(jobModel.getJobTime());

        Picasso.get().load(jobModel.getUrlImage()).into(image);
    }
}