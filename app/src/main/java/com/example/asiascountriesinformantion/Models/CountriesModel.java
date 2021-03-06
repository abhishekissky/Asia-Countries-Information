package com.example.asiascountriesinformantion.Models;

import java.util.Arrays;

public class CountriesModel {

    String name;
    String capital;
    String flag;
    String region;
    String subregion;
    String population;
    String []  borders;
    LanguageModel [] languages;

    public CountriesModel(String name, String capital, String flag, String region, String subregion, String population, String[] borders, LanguageModel[] languages) {
        this.name = name;
        this.capital = capital;
        this.flag = flag;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
        this.borders = borders;
        this.languages = languages;
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

    public String[] getBorders() {
        return borders;
    }

    public void setBorders(String[] borders) {
        this.borders = borders;
    }

    public LanguageModel[] getLanguages() {
        return languages;
    }

    public void setLanguages(LanguageModel[] languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "CountriesModel{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", flag='" + flag + '\'' +
                ", region='" + region + '\'' +
                ", subregion='" + subregion + '\'' +
                ", population='" + population + '\'' +
                ", languages=" + Arrays.toString(languages) +
                '}';
    }
}
