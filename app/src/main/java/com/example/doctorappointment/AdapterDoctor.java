package com.example.doctorappointment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class AdapterDoctor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    List<DataDoctor> data= Collections.emptyList();
    DataDoctor current;
    int currentPos=0;

    // create constructor to initialize context and data sent from Appointment
    public AdapterDoctor(Context context, List<DataDoctor> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when ViewHolder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_doctor, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in RecyclerView to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        DataDoctor current=data.get(position);
        myHolder.textDoctorName.setText(current.doctorName);
        myHolder.textSpeciality.setText(current.speciality);
    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textDoctorName;
        TextView textSpeciality;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textDoctorName= (TextView) itemView.findViewById(R.id.textDoctorName);
            textSpeciality= (TextView) itemView.findViewById(R.id.textSpeciality);
            itemView.setOnClickListener(this);
        }

        // Click event for all items
        @Override
        public void onClick(View v) {

            Toast.makeText(context, "You clicked on doctors", Toast.LENGTH_SHORT).show();

        }

    }

}
