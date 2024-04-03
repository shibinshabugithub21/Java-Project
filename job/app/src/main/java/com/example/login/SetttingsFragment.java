package com.example.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class SetttingsFragment extends Fragment {

    private Button btn,btn2,btn3;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setttings, container, false);
        btn = v.findViewById(R.id.logout);
        btn2 = v.findViewById(R.id.share);
        btn3 = v.findViewById(R.id.contact);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "logout successfully ", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getActivity(),MainActivity.class);
                startActivity(i);


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s= new Intent(Intent.ACTION_SEND);
                s.setType("text/plain");
                s.putExtra(Intent.EXTRA_SUBJECT,"INSERT SUBJECT HEAR");
                String app_url="http://play.google.com/store/apps/details?id=my.example.javatpoint";
                s.putExtra(Intent.EXTRA_TEXT,app_url);
                startActivity(Intent.createChooser(s,"s"));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+91 9207951313"));
                startActivity(c);
            }
        });

        return v;

    }
}