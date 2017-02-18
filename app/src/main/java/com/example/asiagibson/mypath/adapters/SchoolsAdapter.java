package com.example.asiagibson.mypath.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asiagibson.mypath.models.Schools;
import com.example.asiagibson.mypath.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nesada Koca on 2/18/2017.
 */

public class SchoolsAdapter extends RecyclerView.Adapter<SchoolsAdapter.SchoolVHolder> {


    List<Schools> schoolsList;

    public SchoolsAdapter() {
        schoolsList = new ArrayList<>();
    }


    public void setSchoolsList(List<Schools> mSchoolsList) {
        this.schoolsList = mSchoolsList;
        notifyDataSetChanged();
    }

    @Override
    public SchoolVHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_school_item, parent, false);

        return new SchoolVHolder(view);
    }

    @Override
    public void onBindViewHolder(SchoolVHolder holder, int position) {

        Schools schools = schoolsList.get(position);

        holder.bind(schools);

    }

    @Override
    public int getItemCount() {
        return schoolsList.size();
    }


    public class SchoolVHolder extends RecyclerView.ViewHolder {

        TextView mTv1, mTv2, mTv3, mTv4;


        public SchoolVHolder(View itemView) {
            super(itemView);

            mTv1 = (TextView) itemView.findViewById(R.id.tv1);
            mTv2 = (TextView) itemView.findViewById(R.id.tv2);
            mTv3 = (TextView) itemView.findViewById(R.id.tv3);
            mTv4 = (TextView) itemView.findViewById(R.id.tv4);
        }

        public void bind(Schools schools) {

            mTv1.setText(schools.getAddress());
            mTv2.setText(schools.getBorough());
            mTv3.setText(schools.getContact_number());
            mTv4.setText(schools.getProgram_site_name());

        }
    }
}
