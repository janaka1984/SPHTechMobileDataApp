package com.example.mobiledataapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHolder extends SQLiteOpenHelper
{
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UsageData";
    // Contacts table name
    private static final String TABLE_Data= "Data";
    private static final String TABLE_Check= "Count";


    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_YEAR = "year";
    private static final String KEY_TOTAL= "total";
    private static final String KEY_QUATER_COUNT = "count";
    private static final String KEY_QUATER1="quater1";
    private static final String KEY_QUATER2="quater2";
    private static final String KEY_QUATER3="quater3";
    private static final String KEY_QUATER4="quater4";


    public DbHolder(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DbHolder(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String CREATE_TABLE_MEMBERS="CREATE TABLE " + TABLE_Data + "("
                + KEY_ID +" INTEGER PRIMARY KEY,"
                + KEY_YEAR +" TEXT,"
                + KEY_TOTAL +" TEXT,"
                + KEY_QUATER_COUNT +" TEXT,"
                + KEY_QUATER1 +" TEXT,"
                + KEY_QUATER2 +" TEXT,"
                + KEY_QUATER3 +" TEXT,"
                + KEY_QUATER4 +" TEXT"
                + ")";

      /*  String CREATE_TABLE_CHECK="CREATE TABLE " + TABLE_Check + "("
                + KEY_ID +" INTEGER PRIMARY KEY,"
                + KEY_YEAR +" TEXT"
                + ")";
*/




        sqLiteDatabase.execSQL(CREATE_TABLE_MEMBERS);
    //    sqLiteDatabase.execSQL(CREATE_TABLE_CHECK);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_Data);
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_Check);

        onCreate(sqLiteDatabase);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    public void AddData(DbModel model)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_YEAR, model.getYear());
        values.put(KEY_TOTAL, model.getTotal());
        values.put(KEY_QUATER_COUNT, model.getQuaterCount());
        values.put(KEY_QUATER1, model.getQuater1());
        values.put(KEY_QUATER2, model.getQuater2());
        values.put(KEY_QUATER3, model.getQuater3());
        values.put(KEY_QUATER4, model.getQuater4());

        db.insert(TABLE_Data, null, values);
        db.close();
    }
  /*  public void AddCount(DbModel model)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_ID, model.getTotal());
        db.insert(TABLE_Check, null, values);
        db.close();
    }*/

    //=========================GETTING ALL MEMBER  =========================
    public List<DbModel> GetAllData() {
        List<DbModel> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_Data;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DbModel ads = new  DbModel();
                ads.setYear(cursor.getString(1));
                ads.setTotal(String.valueOf(cursor.getString(2)));
                ads.setQuaterCount(cursor.getString(3));
                ads.setQuater1(cursor.getString(4));
                ads.setQuater2(cursor.getString(5));
                ads.setQuater3(cursor.getString(6));
                ads.setQuater4(cursor.getString(7));



                // Adding contact to list
                contactList.add(ads);
            } while (cursor.moveToNext());
        }
        // return contact list
        return contactList;
    } //=========================GETTING ALL MEMBER  =========================
    public int counter () {
        List<DbModel> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_Data;
        int count=0;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
           count=1;
        }
        else {
            count = 0;
        }// return contact list
        return count;
    }



}

