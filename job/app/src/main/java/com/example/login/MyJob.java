package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MyJob extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<String> name, age, gender, organtype, blood;
    DBHelper1 DB;
    MyAdapter1 adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_job);




        DB = new DBHelper1(this);
        name = new ArrayList<>();
        age = new ArrayList<>();
        gender = new ArrayList<>();
        organtype = new ArrayList<>();
        blood = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter1(this, name, age, gender, organtype, blood);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();


    }

    private void displaydata() {

        Cursor cursor = DB.getdata();
        if(cursor.getCount()==0)
        {
            Toast.makeText(MyJob.this,"No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            while (cursor.moveToNext())
            {
                name.add(cursor.getString(0));
                age.add(cursor.getString(1));
                gender.add(cursor.getString(2));
                organtype.add(cursor.getString(3));
                blood.add(cursor.getString(4));


            }
        }

    }
}