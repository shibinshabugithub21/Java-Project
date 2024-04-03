package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addjob extends AppCompatActivity {


    EditText name2, age2,gender2, organtype2,blood2;
    Button save2,btn3;
    DBHelper1 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addjob);


        name2=findViewById(R.id.ProfilePatientName);
        age2=findViewById(R.id.ProfileAge);
        gender2=findViewById(R.id.ProfileGender);
        organtype2=findViewById(R.id.ProfileOrganType);
        blood2=findViewById(R.id.ProfileBloodGroup);

        btn3 = findViewById(R.id.delete);
        save2=findViewById(R.id.insert);
        DB = new DBHelper1(this);

        save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name2TXT = name2.getText().toString();
                String age2TXT = age2.getText().toString();
                String gender2TXT= gender2.getText().toString();
                String organtype2TXT= organtype2.getText().toString();
                String blood2TXT= blood2.getText().toString();


                Boolean checkinsertdata = DB.insertuserdata(name2TXT, age2TXT, gender2TXT, organtype2TXT, blood2TXT);
                if(checkinsertdata==true)
                    Toast.makeText(Addjob.this,"New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Addjob.this,"New Entry Not Inserted",Toast.LENGTH_SHORT).show();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name2.getText().toString();

                Boolean checkdeletedata = DB.deletedata(nameTXT);
                if(checkdeletedata==true)
                    Toast.makeText(Addjob.this,"Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Addjob.this," Entry Not Deleted",Toast.LENGTH_SHORT).show();
            }
        });


    }
}