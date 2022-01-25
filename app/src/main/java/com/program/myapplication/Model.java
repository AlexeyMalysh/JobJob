package com.program.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Model{
    private int id;



    public void setId(int id) {
        this.id = id;
        Log.e("qwqrqfffqwf", String.valueOf(this.id));
    }

    private String city;
    private String name;
    private String lastname;
    private String threename;
    private String otch;
    private String dateBirth;
    private String nationality;
    private String email;
    private String phoneNumber;

    private static final Model INSTANCE = new Model();

//    public static final String DATABASE_NAME = "SQLiteExample.db";
//    private static final int DATABASE_VERSION = 1;
//
//
//    public static final String PERSON_TABLE_NAME = "person";
//
//    public static final String PERSON_CITY = "city";
//    public static final String PERSON_NAME = "name";
//    public static final String PERSON_LASTNAME = "lastname";
//    public static final String PERSON_OTCH = "otch";
//    public static final String PERSON_DATEBIRTHDAY = "dateBirth";
//    public static final String PERSON_NATIONALITY = "nationality";
//    public static final String PERSON_EMAIL = "email";
//    public static final String PERSON_PHONENUMBER = "phoneNumber";
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(
//                "CREATE TABLE " + PERSON_TABLE_NAME +
//                        "(" + PERSON_CITY + " TEXT, " +
//                        PERSON_NAME + " TEXT, " +
//                        PERSON_LASTNAME + " TEXT, " +
//                        PERSON_OTCH + " TEXT, " +
//                        PERSON_DATEBIRTHDAY + " TEXT, " +
//                        PERSON_NATIONALITY + " TEXT, " +
//                        PERSON_EMAIL + " TEXT, " +
//                        PERSON_PHONENUMBER + " TEXT)"
//        );
//    }
//
//
//
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + PERSON_TABLE_NAME);
//        onCreate(db);
//    }
//
//
//
//
//
//
//
//
//    private Model(){
//        super();
//
//    }
//
//    private Model(Context context){
//        super(context, DATABASE_NAME , null, DATABASE_VERSION);
//    }
//
//
//    public boolean insertPerson(String city, String name, String lastname, String threename, String dateBirth, String nationality
//            ,String email, String phoneNumber) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put(PERSON_CITY, city);
//        contentValues.put(PERSON_NAME, name);
//        contentValues.put(PERSON_LASTNAME, lastname);
//        contentValues.put(PERSON_OTCH, threename);
//        contentValues.put(PERSON_DATEBIRTHDAY, dateBirth);
//        contentValues.put(PERSON_NATIONALITY, nationality );
//        contentValues.put(PERSON_EMAIL, email);
//        contentValues.put(PERSON_PHONENUMBER, phoneNumber);
//
//
//        db.insert(PERSON_TABLE_NAME, null, contentValues);
//        return true;
//    }


    public int getId() {
        Log.e("000", String.valueOf(this.id));
        return this.id;

    }

    public static Model getInstance(){
        return INSTANCE;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getOtch() {
        return otch;
    }

    public void setOtch(String otch) {
        this.otch = otch;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
