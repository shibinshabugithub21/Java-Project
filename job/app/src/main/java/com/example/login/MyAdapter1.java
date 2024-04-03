package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MyViewHolder> {
    private Context context1;
    private ArrayList name1_id, age1_id, gender1_id, organtype1_id, bloodgroup1_id;

    public MyAdapter1(Context context1, ArrayList name1_id, ArrayList age1_id, ArrayList gender1_id, ArrayList organtype1_id, ArrayList bloodgroup1_id) {
        this.context1 = context1;
        this.name1_id = name1_id;
        this.age1_id = age1_id;
        this.gender1_id = gender1_id;
        this.organtype1_id = organtype1_id;
        this.bloodgroup1_id = bloodgroup1_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context1).inflate(R.layout.donation_view,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name1_id.setText(String.valueOf(name1_id.get(position)));
        holder.age1_id.setText(String.valueOf(age1_id.get(position)));
        holder.gender1_id.setText(String.valueOf(gender1_id.get(position)));
        holder.organtype1_id.setText(String.valueOf(organtype1_id.get(position)));
        holder.bloodgroup1_id.setText(String.valueOf(bloodgroup1_id.get(position)));



    }

    @Override
    public int getItemCount() {return name1_id.size();}

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name1_id,age1_id, gender1_id, organtype1_id,bloodgroup1_id ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name1_id = itemView.findViewById(R.id.textname);
            age1_id = itemView.findViewById(R.id.textmobile);
            gender1_id = itemView.findViewById(R.id.textadhaar);
            organtype1_id = itemView.findViewById(R.id.textblood);
            bloodgroup1_id = itemView.findViewById(R.id.textgender);






        }
    }
}
