package com.example.asiascountriesinformantion;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.asiascountriesinformantion.DaoClass.DaoClass;
import com.example.asiascountriesinformantion.EntryClass.UserModel;


@Database(entities = {UserModel.class},version = 1)
public abstract class DatabaseClass extends RoomDatabase {

    public abstract DaoClass getDao();

    public static DatabaseClass instance;

    static DatabaseClass getDatabase(final Context context){
        if(instance==null){
            synchronized (DatabaseClass.class){
                instance = Room.databaseBuilder(context,DatabaseClass.class,"DATABASE").allowMainThreadQueries().build();
            }
        }
        return instance;
    }
}
