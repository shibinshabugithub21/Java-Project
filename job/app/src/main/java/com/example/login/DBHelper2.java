package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper2 extends SQLiteOpenHelper {
    public DBHelper2(@Nullable Context context) {
        super(context, "Userdata.dp", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {

        DB.execSQL("create Table Userdetails(name TEXT primary key, mobile TEXT, adhaar TEXT, blood TEXT, gender TEXT, place TEXT, state TEXT, address TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {

        DB.execSQL("drop Table if exists Userdetails");

    }

    public Boolean insertuserdata(String name, String mobile, String adhaar, String blood, String gender, String place, String state, String address){

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("mobile",mobile);
        contentValues.put("adhaar",adhaar);
        contentValues.put("blood" ,blood);
        contentValues.put("gender" ,gender);
        contentValues.put("place" ,place);
        contentValues.put("state" ,state);
        contentValues.put("address" ,address);




        long result=DB.insert("userdetails", null,contentValues);
        if(result==-1){
            return false;
        }else {
            return true;
        }

    }


    public Cursor getdata(){

        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;

    }



}
