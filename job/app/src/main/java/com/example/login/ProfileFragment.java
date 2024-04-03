package com.example.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.Nullable;

public class ProfileFragment extends Fragment {
    private EditText ed1, ed2, ed3, ed4,ed5;

    RadioButton rg1,rg2;
    Button pr1;
    private DBHelper DB;
    private ProfileFragment profileFragment;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        ed1=v.findViewById(R.id.edtxt_p);
        ed2=v.findViewById(R.id.edtxt_p2);
        rg1=v.findViewById(R.id.rbtn1);
        rg2=v.findViewById(R.id.rbtn2);
        ed3=v.findViewById(R.id.mt1);
        ed4=v.findViewById(R.id.em1);
        ed5=v.findViewById(R.id.num5);
        pr1=v.findViewById(R.id.btnp1);
        DB=new DBHelper(getActivity());


        pr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=ed1.getText().toString();
                String dobTXT=ed2.getText().toString();
                String addressTXT=ed3.getText().toString();
                String emailTXT=ed4.getText().toString();
                String mobileTXT=ed5.getText().toString();
                String maleTXT=rg1.getText().toString();
                String femaleTXT=rg2.getText().toString();
                Boolean checkinsertdata=DB.insertuserdata(nameTXT,dobTXT,maleTXT,femaleTXT,addressTXT,emailTXT,mobileTXT);
                if(checkinsertdata=true)
                    Toast.makeText(getActivity(), "Details added sucessfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getActivity(), "Entry not updated", Toast.LENGTH_SHORT).show();


            }

        });

        return v;
    }
}
