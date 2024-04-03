package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList name_id, mobile_id, adhaar_id, blood_id, gender_id, place_id, state_id, address_id;

    public MyAdapter(Context context, ArrayList name_id, ArrayList mobile_id, ArrayList adhaar_id, ArrayList blood_id, ArrayList gender_id, ArrayList place_id, ArrayList state_id, ArrayList address_id) {
        this.context = context;
        this.name_id = name_id;
        this.mobile_id = mobile_id;
        this.adhaar_id = adhaar_id;
        this.blood_id = blood_id;
        this.gender_id = gender_id;
        this.place_id = place_id;
        this.state_id = state_id;
        this.address_id = address_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.mobile_id.setText(String.valueOf(mobile_id.get(position)));
        holder.adhaar_id.setText(String.valueOf(adhaar_id.get(position)));
        holder.blood_id.setText(String.valueOf(blood_id.get(position)));
        holder.gender_id.setText(String.valueOf(gender_id.get(position)));
        holder.place_id.setText(String.valueOf(place_id.get(position)));
        holder.state_id.setText(String.valueOf(state_id.get(position)));
        holder.address_id.setText(String.valueOf(address_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_id,mobile_id, adhaar_id, blood_id,gender_id,place_id,state_id ,address_id ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id = itemView.findViewById(R.id.textname);
            mobile_id = itemView.findViewById(R.id.textmobile);
            adhaar_id = itemView.findViewById(R.id.textadhaar);
            blood_id = itemView.findViewById(R.id.textblood);
            gender_id = itemView.findViewById(R.id.textgender);
            place_id = itemView.findViewById(R.id.textplace);
            state_id = itemView.findViewById(R.id.textstate);
            address_id = itemView.findViewById(R.id.textaddress);





        }
    }
}
