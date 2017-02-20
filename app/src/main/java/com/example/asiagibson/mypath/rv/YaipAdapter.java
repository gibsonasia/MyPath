package com.example.asiagibson.mypath.rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asiagibson.mypath.R;
import com.example.asiagibson.mypath.model.Location;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asiagibson on 2/18/17.
 */

public class YaipAdapter extends RecyclerView.Adapter<YaipViewHolder> {

    private final Context context;
    List<Location> yaipLocation;

    public YaipAdapter(Context context) {
        this.context = context;
        yaipLocation = new ArrayList<>();
    }

    public void setSchoolsList(List<Location> mSYaipList) {
        this.yaipLocation = mSYaipList;
        notifyDataSetChanged();
    }

    @Override
    public YaipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_view, parent, false);
        return new YaipViewHolder(view);
    }

    @Override
    public void onBindViewHolder(YaipViewHolder holder, int position) {
        Location location = yaipLocation.get(position);
        holder.bind(location);


    }

    @Override
    public int getItemCount() {
        return yaipLocation.size();
    }


}
