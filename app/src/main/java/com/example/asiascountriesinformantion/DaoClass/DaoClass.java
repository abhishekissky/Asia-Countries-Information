package com.example.asiascountriesinformantion.DaoClass;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.asiascountriesinformantion.EntryClass.UserModel;

import java.util.List;

@Dao
public interface DaoClass {

    @Insert
    void insertAllData(UserModel model);

    @Query("select * from countries")
    List<UserModel>getAllData();

    @Query("delete from countries")
    void deleteData();

}
