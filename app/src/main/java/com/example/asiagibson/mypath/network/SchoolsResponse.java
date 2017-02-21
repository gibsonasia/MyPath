package com.example.asiagibson.mypath.network;

import com.example.asiagibson.mypath.model.Schools;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by Nesada Koca on 2/18/2017.
 */

public interface SchoolsResponse {

    @GET("resource/jfsi-vq8f.json")
    Call<List<Schools>> schoolsData();
}
