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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                Log.e("SSSSSssss", tvDate.getRawText());
                Log.e("aaaaaqaaaaaaaa", tvDate.getText().toString());
                Log.e("SSSSSssss", tvDate.getText().toString().replaceAll("\\.","/"));

                matcher = Pattern.compile(DATE_PATTERN).matcher(tvDate.getRawText());
                if(!checkDateFormat(tvDate.getText().toString().replaceAll("\\.","/"))){
                    tvDate.setBackgroundResource(R.drawable.error);
                    Toast.makeText(getApplicationContext(), "Заполните все доступные поля корректными данными", Toast.LENGTH_SHORT).show();
                }

                else {
                    Model.getInstance().setDateBirth(tvDate.getText().toString());
                    Log.i("GGGGGGGG", tvDate.getText().toString());
                    showActivity();
                }
            }
        });

    }

    public Boolean checkDateFormat(String date){
        if (date == null || !date.matches("^(1[0-9]|0[1-9]|3[0-1]|2[1-9])/(0[1-9]|1[0-2])/[0-9]{4}$"))
            return false;
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        try {
            format.parse(date);
            return true;
        }catch (ParseException e){
            return false;
        }
    }

    public void showActivity() {
        Intent intent = new Intent(activity_3.this, activity_4.class);
        startActivity(intent);

    }


    private Pattern pattern;
    private Matcher matcher;

    private static final String DATE_PATTERN =
            "(0?[1-9]|1[012]) [/.-] (0?[1-9]|[12][0-9]|3[01]) [/.-] ((19|20)\\d\\d)";


    /**
     * Validate date format with regular expression
     * @param date date address for validation
     * @return true valid date format, false invalid date format
     */
    public boolean validate(final String date) {

//        matcher = pattern.matcher(date);
//
//        if(matcher.matches()){
//            matcher.reset();
//
//            if(matcher.find()){
//                String day = matcher.group(1);
//                String month = matcher.group(2);
//                int year = Integer.parseInt(matcher.group(3));
        String day = date.substring(0, 2);
        int dayN = Integer.parseInt(date.substring(0, 1));
        int firstN = Integer.parseInt(date.substring(0));
        int seconN = Integer.parseInt(date.substring(1));
        int monthF = Integer.parseInt(date.substring(2, 3));
        int monthS = Integer.parseInt(date.substring(3, 4));
        String month = date.substring(2, 4);
        int monthN = Integer.parseInt(month);
        int year = Integer.parseInt(date.substring(4, 8));


        int yearF = Integer.parseInt(date.substring(4, 5));
        int yearS = Integer.parseInt(date.substring(5, 6));
        int yearT = Integer.parseInt(date.substring(6, 7));
        int yearR = Integer.parseInt(date.substring(7, 8));


        if (dayN > 3) {
            return false;
        } else if (monthF > 1) {
            return false;
        } else if (monthF == 1 && monthS > 2) {
            return false;
        } else if (yearF > 2 || yearF == 0) {
            return false;
        } else if (yearF <= 2) {
            if (yearF == 1 && yearS < 9) {
                return false;
            } else if (yearF == 2 && yearS != 0) {
                return false;
            } else if (yearF == 2 && yearS == 0 && yearR >= 1) {
                return false;
            }
        } else if (day.equals("31") &&
                (month.equals("4") || month.equals("6") || month.equals("9") ||
                        month.equals("11") || month.equals("04") || month.equals("06") ||
                        month.equals("09"))) {
            return false; // only 1,3,5,7,8,10,12 has 31 days
        } else if (month.equals("2") || month.equals("02")) {
            //leap year
            if (year % 4 == 0) {
                if (day.equals("30") || day.equals("31")) {
                    return false;
                } else {
                    return true;
                }
            } else {

                if (day.equals("29") || day.equals("30") || day.equals("31")) {
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            return true;
        }
        return true;
    }







}

