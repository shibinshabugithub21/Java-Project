package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.util.ArrayList;

public class seejob extends AppCompatActivity {

    ScrollView scrollView;

    public Button sbtn, lulud, takiond, sonyd, malabard, fedexd;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seejob);





    }

    public void sonyid(View view) {

        Intent intent = new Intent(seejob.this,MyJob.class);
        startActivity(intent);

    }

    public void malabarid(View view) {

        Intent intent = new Intent(seejob.this,MyJob.class);
        startActivity(intent);

    }

    public void fedexid(View view) {

        Intent intent = new Intent(seejob.this,MyJob.class);
        startActivity(intent);

    }

    public void takionid(View view) {
        Intent intent = new Intent(seejob.this,MyJob.class);
        startActivity(intent);

    }

    public void luluid(View view) {

        Intent intent = new Intent(seejob.this,MyJob.class);
        startActivity(intent);

    }

    public void tataid(View view) {

        Intent intent = new Intent(seejob.this,MyJob.class);
        startActivity(intent);

    }
}