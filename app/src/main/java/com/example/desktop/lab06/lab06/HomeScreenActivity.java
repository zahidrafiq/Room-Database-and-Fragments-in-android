package com.example.desktop.lab06.lab06;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.desktop.lab06.R;
import com.example.desktop.lab06.lab06.database.AppDatabase;
import com.example.desktop.lab06.lab06.database.Student;
import com.example.desktop.lab06.lab06.database.StudentDAO;
import com.example.desktop.lab06.lab06.database.Teacher;
import com.example.desktop.lab06.lab06.database.TeacherDAO;


public class HomeScreenActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTeacher, btnStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        btnTeacher = findViewById(R.id.btn_teacher);
        btnStudent = findViewById(R.id.btn_student);
        btnTeacher.setOnClickListener(this);
        btnStudent.setOnClickListener(this);
        populateData();
    }

    private void populateData() {
        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        StudentDAO studentDAO = appDatabase.studentDAO();
        Student student = new Student("ali", "ali@gmail.com");

        studentDAO.insertNewStudent(student);

        student.setName("Ahmed");
        student.setEmail("Ahmed@gmail.com");
        studentDAO.insertNewStudent(student);

        student.setName("Mudassar");
        student.setEmail("Mudassar@gmail.com");
        studentDAO.insertNewStudent(student);

        student.setName("abc");
        student.setEmail("Abc@gmail.com");
        studentDAO.insertNewStudent(student);

        student.setName("Nouman");
        student.setEmail("Nouman@gmail.com");
        studentDAO.insertNewStudent(student);

        TeacherDAO teacherDAO = appDatabase.teacherDAO();
        Teacher teacher = new Teacher("Anum Tariq", "Anum@pucit.edu.pk");
        teacherDAO.insertNewTeacher(teacher);
        teacher.setName("Nazar Khan");
        teacher.setEmail("Nazar@@pucit.edu.pk");
        teacherDAO.insertNewTeacher(teacher);

        teacher.setName("Tariq Butt");
        teacher.setEmail("tariq@@pucit.edu.pk");
        teacherDAO.insertNewTeacher(teacher);

        teacher.setName("Madiha Saleem");
        teacher.setEmail("madiha@@pucit.edu.pk");
        teacherDAO.insertNewTeacher(teacher);

    }

    @Override
    public void onClick(View v) {

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_layout);
        switch (v.getId()) {
            case R.id.btn_teacher:
                setTitle("Teacher");
                TeacherFragment teacherFragment = new TeacherFragment();
                if (fragment == null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .add(R.id.fragment_layout, teacherFragment)
                            .commit();
                } else {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_layout, teacherFragment)
                            .commit();
                }
                break;
            case R.id.btn_student:
                setTitle("Student");
                StudentFragment studentFragment = new StudentFragment();
                if (fragment == null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .add(R.id.fragment_layout, studentFragment)
                            .commit();
                } else {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_layout, studentFragment)
                            .commit();
                }
                break;
        }

    }
}
