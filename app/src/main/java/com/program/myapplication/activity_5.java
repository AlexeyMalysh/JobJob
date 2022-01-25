package com.program.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.sapereaude.maskedEditText.MaskedEditText;

public class activity_5 extends Activity {
    EditText mail;
    Button next5;

//    String emailPattern = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
//             "\\@" +
//             "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
//             "(" +
//             "\\." +
//             "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
//             ")+"

   // String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
   //String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//    String emailPattern = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
//           + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
//           + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
//           + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
//           + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
//           + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";


    public boolean emailValidator(EditText etMail) {

        // extract the entered data from the EditText
        String emailToText = etMail.getText().toString();

        // Android offers the inbuilt patterns which the entered
        // data from the EditText field needs to be compared with
        // In this case the the entered data needs to compared with
        // the EMAIL_ADDRESS, which is implemented same below
        if (!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()) {
            return true;

        } else {
            return false;

        }
    }
    /** Called when the activity is first created. */

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
       mail = findViewById(R.id.mail_input);
        next5 = findViewById(R.id.next5);


        String email = mail.getText().toString().trim();
        next5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!emailValidator(mail)){
                    mail.setBackgroundResource(R.drawable.error);
                    Toast.makeText(getApplicationContext(), "Заполните все доступные поля корректно", Toast.LENGTH_SHORT).show();
                }

                else {
                    Model.getInstance().setEmail(mail.getText().toString());
                    Log.i("GGGGGGGG", mail.getText().toString());
                    showActivity();
                }
            }
        });

    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public void showActivity() {
        Intent intent = new Intent(activity_5.this, activity_6.class);
        startActivity(intent);

    }

    public static boolean isEmailAddressValid(String email) {
        boolean isEmailValid = false;

        String strExpression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern objPattern = Pattern.compile(strExpression , Pattern.CASE_INSENSITIVE);
        Matcher objMatcher = objPattern .matcher(inputStr);
        if (objMatcher .matches()) {
            isEmailValid = true;
        }
        return isEmailValid ;
    }






}
