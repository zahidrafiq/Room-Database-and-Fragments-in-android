package com.example.desktop.lab06.lab06.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface TeacherDAO {

    @Query("Select * from teacher")
    public List<Teacher> getAllTeacher();

    @Delete
    public void deleteTeacher(Teacher teacher);


    @Insert(onConflict = REPLACE)
    public void insertNewTeacher(Teacher teacher);

}
