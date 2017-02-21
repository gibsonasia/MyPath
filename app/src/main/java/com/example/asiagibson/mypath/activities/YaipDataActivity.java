package com.example.asiagibson.mypath.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.asiagibson.mypath.R;
import com.example.asiagibson.mypath.network.YaipResponse;
import com.example.asiagibson.mypath.model.Location;
import com.example.asiagibson.mypath.rv.YaipAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by asiagibson on 2/18/17.
 */

public class YaipDataActivity extends Activity
{
    String NOTWORKING = "Data NOT WORKing";
    String TAG = "Yaip Frag";
    RecyclerView rv;
    YaipAdapter adapter;
    Retrofit mRetrofit;
    private final String BASE_URL = "https://data.cityofnewyork.us/";
    private String borough;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yaip_data);


            rv = (RecyclerView) findViewById(R.id.recycler_view);

            Bundle bundle = getIntent().getExtras();
            borough = (bundle.getString("borough_community"));

            adapter = new YaipAdapter(getBaseContext());
            rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                    LinearLayoutManager.VERTICAL,
                    false));

            rv.setAdapter(adapter);

            setUpRetrofit();


        }

    public void setUpRetrofit() {
        mRetrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        YaipResponse yaipResponse = mRetrofit.create(YaipResponse.class);

        Call<List<Location>> listCall = yaipResponse.LocationData();
        listCall.enqueue(new Callback<List<Location>>() {
            @Override
            public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {

                if (response.isSuccessful()) {

                    List<Location> locations = response.body();

                    adapter.setSchoolsList(locations);

                    List<Location> temp = new ArrayList<>();

                    for (Location d : locations) {
                        if (d.getBorough_community().equals(borough)) {
                            temp.add(d);
                        }
                    }

                    adapter.setSchoolsList(temp);

                }
            }

            @Override
            public void onFailure(Call<List<Location>> call, Throwable t) {
                System.out.print("Not working");
                Log.d(NOTWORKING, "It is not workig");

            }
        });
    }

//        Bundle bundle = getIntent().getExtras();
//        borough = (bundle.getString("borough"));
//
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//
//        YaipFragment fragment = new YaipFragment();
//        ft.add(R.id.frag_container, fragment);
//        ft.commit();
    }

