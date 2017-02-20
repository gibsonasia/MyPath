package com.example.asiagibson.mypath.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asiagibson.mypath.R;
import com.example.asiagibson.mypath.YaipResponse;
import com.example.asiagibson.mypath.model.Location;
import com.example.asiagibson.mypath.rv.YaipAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by asiagibson on 2/18/17.
 */

public class YaipFragment extends Fragment {

    String NOTWORKING = "Data NOT WORKing";
    String TAG = "Yaip Frag";
    RecyclerView rv;
    YaipAdapter adapter;
    Retrofit mRetrofit;
    private final String BASE_URL = "https://data.cityofnewyork.us/";

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        final View view = inflater.inflate(R.layout.fragment_yaip, container, false);
//
//        rv = (RecyclerView) view.findViewById(R.id.recycler_view);
//
//        adapter = new YaipAdapter();
//        rv.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
//        rv.setAdapter(adapter);
//        setUpRetrofit();
//        return view;
//
//
//    }
//
//    public void setUpRetrofit() {
//        mRetrofit = new Retrofit
//                .Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        YaipResponse yaipResponse = mRetrofit.create(YaipResponse.class);
//
//        Call<List<Location>> listCall = yaipResponse.LocationData();
//        listCall.enqueue(new Callback<List<Location>>() {
//            @Override
//            public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
//
//                if (response.isSuccessful()) {
//
//                    List<Location> locations = response.body();
//
//                    adapter.setSchoolsList(locations);
//
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Location>> call, Throwable t) {
//                System.out.print("Not working");
//                Log.d(NOTWORKING, "It is not workig");
//
//            }
//        });
//    }
}


