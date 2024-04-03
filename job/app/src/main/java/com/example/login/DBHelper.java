package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super (context,"userdata.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("Create Table Userdetails(name TEXT primary key,dob text,male,female,Address,email,mobile )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");

    }
    public boolean insertuserdata (String name, String dob,String maleTXT,String female , String Address,String emailTXT, String mobileTXT ){
        SQLiteDatabase DB= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", name);
        contentValues.put("dob",dob);
        contentValues.put("male",maleTXT);
        contentValues.put("female",female);
        contentValues.put("Address",Address);
        contentValues.put("email",emailTXT);
        contentValues.put("mobile",mobileTXT);
        long result=DB.insert("Userdetails",null,contentValues);
        if(result == -1)

        {
            return false;
        }
        else

        {
            return true;
        }
    }
    public boolean updateuserdata(String name,String contact,String dob){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact",contact);
        contentValues.put("dob",dob);

        Cursor cursor= DB.rawQuery("select * from Userdetails where name= ?",new String[]{name});
        if (cursor.getCount()>0){
            long result = DB.update("Userdetails",contentValues,"name=?",new String[]{name});

            if (result == -1) {
                return false;
            }else {
                return true;
            }
        }else{
            return false;
        }
    }
    public boolean deleteuserdata(String name)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor =DB.rawQuery("select * from Userdetails where name=?",new String[] {name});
        if (cursor.getCount()>0){

            long result = DB.delete("Userdetails","name=?",new String[]{name});

            if (result==-1) {
                return false;
            }
            else {
                return true;
            }}
        else {
            return false;

        }
    }
    public Cursor getdata(String name)
    {
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("select *from Userdetails",null);
        return  cursor;
    }
}

