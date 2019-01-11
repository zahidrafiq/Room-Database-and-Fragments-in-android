package com.example.desktop.lab06.lab06;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.desktop.lab06.R;
import com.example.desktop.lab06.lab06.database.Student;

import java.util.List;


public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {

    List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.textViewName.setText(student.getName());
        holder.textViewEmail.setText(student.getEmail());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewEmail;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewEmail = itemView.findViewById(R.id.text_view_email);
        }
    }
}
