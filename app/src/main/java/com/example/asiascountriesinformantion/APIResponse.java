package com.example.asiascountriesinformantion;


import com.example.asiascountriesinformantion.Models.CountriesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIResponse {


    @GET("/rest/v2/region/asia")
    Call<List<CountriesModel>> getData();


}
