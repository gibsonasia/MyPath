package com.example.asiagibson.mypath.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.asiagibson.mypath.R;
import com.example.asiagibson.mypath.adapters.SchoolsAdapter;
import com.example.asiagibson.mypath.model.Schools;
import com.example.asiagibson.mypath.network.SchoolsResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nesada Koca on 2/18/2017.
 */

public class SchoolsActivity extends AppCompatActivity {

    private RecyclerView mRvInfo;
    private SchoolsAdapter mSchoolsAdapter;
    private Retrofit mRetrofit;
    private final String BASEURL = "https://data.cityofnewyork.us/";
    private String borough;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        mRvInfo = (RecyclerView) findViewById(R.id.rv_info);

        Bundle bundle = getIntent().getExtras();
        borough = (bundle.getString("borough"));

        setUpAdapter();
        setUpRetrofit();

    }

    public void setUpAdapter() {

        mSchoolsAdapter = new SchoolsAdapter(getBaseContext());

        mRvInfo.setAdapter(mSchoolsAdapter);
        mRvInfo.setHasFixedSize(true);
        mRvInfo.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false));
    }

    public void setUpRetrofit() {

        mRetrofit = new Retrofit
                .Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SchoolsResponse schoolsResponse = mRetrofit.create(SchoolsResponse.class);
        Call<List<Schools>> listCall = schoolsResponse.schoolsData();

        listCall.enqueue(new Callback<List<Schools>>() {

                             @Override
                             public void onResponse(Call<List<Schools>> call, Response<List<Schools>> response) {
                                 if (response.isSuccessful()) {
                                     List<Schools> schools = response.body();

                                     List<Schools> temp = new ArrayList<>();

                                     for (Schools d : schools) {
                                         if (d.getBorough().equals(borough)) {
                                             temp.add(d);
                                         }
                                     }

                                     mSchoolsAdapter.setSchoolsList(temp);
                                 }
                             }

                             @Override
                             public void onFailure (Call < List < Schools >> call, Throwable t){
                                 Toast.makeText(getBaseContext(), "Not Working!", Toast.LENGTH_LONG).show();
                             }
                         }

        );
    }
}
