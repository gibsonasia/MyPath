package com.example.asiagibson.mypath.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.asiagibson.mypath.EsllResponse;
import com.example.asiagibson.mypath.R;
import com.example.asiagibson.mypath.fragments.YaipFragment;
import com.example.asiagibson.mypath.model.EsllData;
import com.example.asiagibson.mypath.model.Location;
import com.example.asiagibson.mypath.models.Schools;
import com.example.asiagibson.mypath.rv.EsllAdapter;
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

public class EsllActivity extends Activity {

    String NOTWORKING = "Data NOT WORKing";
    String TAG = "Yaip Frag";
    RecyclerView rv;
    EsllAdapter adapter;
    Retrofit mRetrofit;
    private final String BASE_URL = "https://data.cityofnewyork.us/";
    String borough;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esll);

        rv = (RecyclerView) findViewById(R.id.recycler_view);

        Bundle bundle = getIntent().getExtras();
        borough = (bundle.getString("borough_community"));

        adapter = new EsllAdapter(getBaseContext());
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

        EsllResponse esllResponse = mRetrofit.create(EsllResponse.class);

        Call<List<EsllData>> listCall = esllResponse.EsllData();
        listCall.enqueue(new Callback<List<EsllData>>() {
            @Override
            public void onResponse(Call<List<EsllData>> call, Response<List<EsllData>> response) {

                if (response.isSuccessful()) {

                    List<EsllData> esllDatas = response.body();

                    adapter.setEsllDataList(esllDatas);

                    List<EsllData> temp = new ArrayList<>();

                    for (EsllData d : esllDatas) {
                        if (d.getBorough_community().equals(borough)) {
                            temp.add(d);
                        }
                    }

                    adapter.setEsllDataList(temp);
                }
            }

            @Override
            public void onFailure(Call<List<EsllData>> call, Throwable t) {
                System.out.print("Not working");
                Log.d(NOTWORKING, "It is not workig");

            }
        });
    }
}
