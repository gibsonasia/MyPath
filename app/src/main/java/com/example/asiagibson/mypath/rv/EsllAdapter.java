package com.example.asiagibson.mypath.rv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asiagibson.mypath.R;
import com.example.asiagibson.mypath.model.EsllData;
import com.example.asiagibson.mypath.model.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asiagibson on 2/18/17.
 */

public class EsllAdapter extends RecyclerView.Adapter<EsllViewHolder> {

    List<EsllData> esllDataList;

    public EsllAdapter() {
        esllDataList = new ArrayList<>();
    }

    public void setEsllDataList(List<EsllData> mEsllDataList) {
        this.esllDataList = mEsllDataList;
        notifyDataSetChanged();
    }

    @Override
    public EsllViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_esll_view, parent, false);
        return new EsllViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EsllViewHolder holder, int position) {
        EsllData esllData = esllDataList.get(position);
        holder.bind(esllData);
    }

    @Override
    public int getItemCount() {
        return esllDataList.size();
    }
}
