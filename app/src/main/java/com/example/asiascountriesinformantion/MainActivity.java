package com.example.asiascountriesinformantion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.asiascountriesinformantion.EntryClass.UserModel;
import com.example.asiascountriesinformantion.Models.CountriesModel;
import com.example.asiascountriesinformantion.Models.LanguageModel;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        delete = findViewById(R.id.deleteBtn);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseClass.getDatabase(getApplicationContext()).getDao().deleteData();
                getAdapterData();
            }
        });


        if(DatabaseClass.getDatabase(getApplicationContext()).getDao().getAllData()==null||DatabaseClass.getDatabase(getApplicationContext()).getDao().getAllData().isEmpty()){
            getData();
        }else {
            getAdapterData();
        }



    }



    private void getData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIResponse apiResponse = retrofit.create(APIResponse.class);

        apiResponse.getData().enqueue(new Callback<List<CountriesModel>>() {
            @Override
            public void onResponse(Call<List<CountriesModel>> call, Response<List<CountriesModel>> response) {

                List<CountriesModel> countriesModels =  response.body();
//                getAdapterData(crewMembersModel);

                for (CountriesModel countriesModel: countriesModels){

                    String name = countriesModel.getName();
                    String capital = countriesModel.getCapital();
                    String flag = countriesModel.getFlag();
                    String population = countriesModel.getPopulation();
                    String region = countriesModel.getRegion();
                    String subRegion = countriesModel.getSubregion();
                    String language = "";
                    String border="";
                    for(LanguageModel languageModel:countriesModel.getLanguages()){
                        language  = language + " " + languageModel.getName();
                    }
                    for (String borders:countriesModel.getBorders()){
                         border = border +" "+ borders ;

                    }

                    saveData(name,capital,flag,population,region,subRegion,language,border);
                }


                getAdapterData();

                Toast.makeText(MainActivity.this, "Data Successfully Added", Toast.LENGTH_SHORT).show();

//
            }

            @Override
            public void onFailure(Call<List<CountriesModel>> call, Throwable t) {
                    Log.v("Error",t.getMessage());
            }
        });

    }
    private void saveData(String name,String capital,String flag,String population,String region,String subRegion,String language,String border) {

        if(name!=null&& capital!=null&& flag!=null&&population!=null&& region!=null && subRegion!=null && language!=null && border!=null){
            UserModel userModel = new UserModel();
            userModel.setName(name);
            userModel.setBorders(border);
            userModel.setFlag(flag);
            userModel.setCapital(capital);
            userModel.setRegion(region);
            userModel.setSubregion(subRegion);
            userModel.setLanguages(language);
            userModel.setPopulation(population);


            DatabaseClass.getDatabase(MainActivity.this).getDao().insertAllData(userModel);
        }




    }

    public void getAdapterData(){
        Adapter adapter = new Adapter(DatabaseClass.getDatabase(getApplicationContext()).getDao().getAllData(),this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


}