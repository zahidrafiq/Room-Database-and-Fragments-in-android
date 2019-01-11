package com.example.desktop.lab06.lab06;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.desktop.lab06.R;
import com.example.desktop.lab06.lab06.database.AppDatabase;
import com.example.desktop.lab06.lab06.database.Student;
import com.example.desktop.lab06.lab06.database.StudentDAO;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudentFragment extends Fragment {


    public StudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_student, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view_student);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<Student> studentList =AppDatabase.getInstance(getActivity().getApplicationContext())
                .studentDAO().getAllStudent();

        recyclerView.setAdapter(new StudentAdapter(studentList));

//        recyclerView.addItemDecoration(
//                new DividerItemDecoration(getActivity(),
//                        DividerItemDecoration.VERTICAL));
        return rootView;
    }

}
