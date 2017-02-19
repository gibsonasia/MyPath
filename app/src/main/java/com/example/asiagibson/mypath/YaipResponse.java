package com.example.asiagibson.mypath;

import com.example.asiagibson.mypath.model.Location;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by asiagibson on 2/18/17.
 */

public interface YaipResponse  {
    @GET("resource/yh83-kk7j.json")
    Call<List<Location>> LocationData();
}
