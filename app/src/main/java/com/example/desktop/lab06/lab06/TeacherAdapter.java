package com.example.desktop.lab06.lab06;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.desktop.lab06.R;
import com.example.desktop.lab06.lab06.database.Teacher;

import java.util.List;


public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.MyViewHolder> {

    List<Teacher> teacherList;

    public TeacherAdapter(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Teacher teacher = teacherList.get(position);
        holder.textViewName.setText(teacher.getName());
        holder.textViewEmail.setText(teacher.getEmail());
    }

    @Override
    public int getItemCount() {
        return teacherList.size();
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
