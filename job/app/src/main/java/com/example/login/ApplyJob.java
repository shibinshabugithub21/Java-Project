package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ApplyJob extends AppCompatActivity {

    EditText name1,mobile1,adhaar1,blood1,gender1,place1,state1,address1;
    Button save1,view;
    DBHelper2 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_job);

        name1=findViewById(R.id.ProfileName);
        mobile1=findViewById(R.id.ProfileMobile);
        adhaar1=findViewById(R.id.ProfileAdhaar);
        blood1=findViewById(R.id.ProfileBlood);
        gender1=findViewById(R.id.ProfileGender);
        place1=findViewById(R.id.ProfilePlace);
        state1=findViewById(R.id.ProfileState);
        address1=findViewById(R.id.ProfileAddress);
        save1=findViewById(R.id.insert);
        view=findViewById(R.id.views);
        DB = new DBHelper2(this);

        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name1.getText().toString();
                String mobileTXT = mobile1.getText().toString();
                String adhaarTXT= adhaar1.getText().toString();
                String bloodTXT= blood1.getText().toString();
                String genderTXT= gender1.getText().toString();
                String placeTXT= place1.getText().toString();
                String stateTXT= state1.getText().toString();
                String addressTXT= address1.getText().toString();


                Boolean checkinsertdata = DB.insertuserdata(nameTXT, mobileTXT, adhaarTXT, bloodTXT, genderTXT, placeTXT, stateTXT ,addressTXT);
                if(checkinsertdata==true)
                    Toast.makeText(ApplyJob.this,"New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ApplyJob.this,"New Entry Not Inserted",Toast.LENGTH_SHORT).show();
            }
        });


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ApplyJob.this, ViewApplyJob.class));
            }

        });

    }
}