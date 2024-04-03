package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper1 extends SQLiteOpenHelper {
    public DBHelper1(@Nullable Context context) {
        super(context, "Userdata1.dp", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {

        DB.execSQL("create Table Userdetails1(name2 TEXT primary key, age2 TEXT, gender2 TEXT, organtype2 TEXT, blood2 TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {

        DB.execSQL("drop Table if exists Userdetails1");

    }

    public Boolean insertuserdata(String name2, String age2, String gender2, String organtype2, String blood2){

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name2",name2);
        contentValues.put("age2",age2);
        contentValues.put("gender2",gender2);
        contentValues.put("organtype2" ,organtype2);
        contentValues.put("blood2" ,blood2);


        long result=DB.insert("userdetails1", null,contentValues);
        if(result==-1){
            return false;
        }else {
            return true;
        }

    }

    public Boolean deletedata(String name){

        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from Userdetails1 where name2 = ?", new String[] {name});
        if(cursor.getCount()>0) {

            long result = DB.delete("userdetails1", "name2=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }

    }


    public Cursor getdata(){

        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from Userdetails1", null);
        return cursor;

    }



}