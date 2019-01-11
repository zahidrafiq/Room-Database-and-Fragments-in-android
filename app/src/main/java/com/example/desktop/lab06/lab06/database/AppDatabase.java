package com.example.desktop.lab06.lab06.database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = {Student.class, Teacher.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;

    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "lab06")
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }

    public static void destroyInstance() {
        appDatabase = null;
    }


    public abstract TeacherDAO teacherDAO();

    public abstract StudentDAO studentDAO();


}
