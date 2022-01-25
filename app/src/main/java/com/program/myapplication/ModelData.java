package com.program.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ModelData extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "SQLiteExample.db";
    private static final int DATABASE_VERSION = 1;


    public static final String PERSON_TABLE_NAME = "person";
    public static final String PERSON_ID = "id";
    public static final String PERSON_CITY = "city";
    public static final String PERSON_NAME = "name";
    public static final String PERSON_LASTNAME = "lastname";
    public static final String PERSON_OTCH = "otch";
    public static final String PERSON_DATEBIRTHDAY = "dateBirth";
    public static final String PERSON_NATIONALITY = "nationality";
    public static final String PERSON_EMAIL = "email";
    public static final String PERSON_PHONENUMBER = "phoneNumber";

    public ModelData(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @SuppressLint("Range")
    public Model getModel() {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM person", null);



        if (cursor != null)
            cursor.moveToFirst();

        Model model = Model.getInstance();
        model.setId(cursor.getInt(cursor.getColumnIndex(PERSON_ID)));
        model.setCity(cursor.getString(cursor.getColumnIndex(PERSON_CITY)));
        model.setName(cursor.getString(cursor.getColumnIndex(PERSON_NAME)));
        model.setLastname(cursor.getString(cursor.getColumnIndex(PERSON_LASTNAME)));
        model.setOtch(cursor.getString(cursor.getColumnIndex(PERSON_OTCH)));
        model.setDateBirth(cursor.getString(cursor.getColumnIndex(PERSON_DATEBIRTHDAY)));
        model.setNationality(cursor.getString(cursor.getColumnIndex(PERSON_NATIONALITY)));
        model.setEmail(cursor.getString(cursor.getColumnIndex(PERSON_EMAIL)));
        model.setPhoneNumber(cursor.getString(cursor.getColumnIndex(PERSON_PHONENUMBER)));

        // close the db connection
        cursor.close();

        return model;
    }



    public boolean insertPerson( String city, String name, String lastname, String threename, String dateBirth, String nationality
            , String email, String phoneNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(PERSON_CITY, city);
        contentValues.put(PERSON_NAME, name);
        contentValues.put(PERSON_LASTNAME, lastname);
        contentValues.put(PERSON_OTCH, threename);
        contentValues.put(PERSON_DATEBIRTHDAY, dateBirth);
        contentValues.put(PERSON_NATIONALITY, nationality );
        contentValues.put(PERSON_EMAIL, email);
        contentValues.put(PERSON_PHONENUMBER, phoneNumber);


        db.insert(PERSON_TABLE_NAME, null, contentValues);
        return true;
    }

    public void upDate(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PERSON_ID, id);
        db.insert(PERSON_TABLE_NAME,null,contentValues);
    }





    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + PERSON_TABLE_NAME +
                        "(" + PERSON_CITY + " TEXT, " +
                        PERSON_ID + " INTEGER, " +
                        PERSON_NAME + " TEXT, " +

                        PERSON_LASTNAME + " TEXT, " +
                        PERSON_OTCH + " TEXT, " +
                        PERSON_DATEBIRTHDAY + " TEXT, " +
                        PERSON_NATIONALITY + " TEXT, " +
                        PERSON_EMAIL + " TEXT, " +
                        PERSON_PHONENUMBER + " TEXT)"
        );
    }


    public Cursor getPhoneNumber(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT phoneNumber FROM person";
        Cursor res =  db.rawQuery(sql,null);
        return res;
    }






    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PERSON_TABLE_NAME);
        onCreate(db);
    }


}
