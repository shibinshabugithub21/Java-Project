package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class admin extends AppCompatActivity {
    private EditText auser,apass;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        auser=(EditText) findViewById(R.id.edtx06);
        apass=(EditText) findViewById(R.id.edp05);
        login=(Button) findViewById(R.id.btn05);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String admin= auser.getText().toString();
                String password=apass.getText().toString();
                if (auser.getText().toString().equals("admin") && apass.getText().toString().equals("1234")){
                    Toast.makeText(admin.this,"Login Successfull",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(admin.this,PostView.class);
                    startActivity(i);
                }else
                    Toast.makeText(admin.this, "Login Fail!!!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }


}