package com.example.desktop.lab06.lab06.database;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface StudentDAO {

    @Query("Select * from student")
    public List<Student> getAllStudent();

    @Delete
    public void deleteStudent(Student Student);


    @Insert(onConflict = REPLACE)
    public void insertNewStudent(Student Student);

}
