package com.example.asiagibson.mypath;

import com.example.asiagibson.mypath.model.EsllData;
import com.example.asiagibson.mypath.model.Location;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by asiagibson on 2/18/17.
 */

public interface EsllResponse {
    @GET("resource/vmdh-6fvj.json")
    Call<List<EsllData>> EsllData();
}
