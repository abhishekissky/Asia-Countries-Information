package com.example.asiascountriesinformantion.EntryClass;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import io.reactivex.rxjava3.annotations.NonNull;

@Entity(tableName = "countries")
public class UserModel {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    int key;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "capital")
    String capital;

    @ColumnInfo(name = "flag")
    String flag;

    @ColumnInfo(name = "region")
    String region;

    @ColumnInfo(name = "subregion")
    String subregion;

    @ColumnInfo(name = "population")
    String population;

    @ColumnInfo(name = "borders")
    String borders;

    @ColumnInfo(name = "languages")
    String  languages;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getBorders() {
        return borders;
    }

    public void setBorders(String borders) {
        this.borders = borders;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }
}
