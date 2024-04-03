package com.example.login;

import static com.example.login.R.id.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewApplyJob extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<String> name, mobile, adhaar, blood, gender, place, state, address;
    DBHelper2 DB;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_apply_job);


        DB = new DBHelper2(this);
        name = new ArrayList<>();
        mobile = new ArrayList<>();
        adhaar = new ArrayList<>();
        blood = new ArrayList<>();
        gender = new ArrayList<>();
        place = new ArrayList<>();
        state = new ArrayList<>();
        address = new ArrayList<>();

        recyclerView = findViewById(recyclerview);
        adapter = new MyAdapter(this, name, mobile, adhaar, blood, gender, place, state, address);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();


    }

    private void displaydata() {

        Cursor cursor = DB.getdata();
        if (cursor.getCount() == 0) {
            Toast.makeText(ViewApplyJob.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        } else {
            while (cursor.moveToNext()) {
                name.add(cursor.getString(0));
                mobile.add(cursor.getString(1));
                adhaar.add(cursor.getString(2));
                blood.add(cursor.getString(3));
                gender.add(cursor.getString(4));
                place.add(cursor.getString(5));
                state.add(cursor.getString(6));
                address.add(cursor.getString(7));

            }
        }

    }
}