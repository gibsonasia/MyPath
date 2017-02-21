package com.example.asiagibson.mypath.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.asiagibson.mypath.R;
import com.example.asiagibson.mypath.model.Schools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nesada Koca on 2/18/2017.
 */

public class SchoolsAdapter extends RecyclerView.Adapter<SchoolsAdapter.SchoolVHolder> {


    List<Schools> schoolsList;

    public SchoolsAdapter(Context context) {
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


    public class SchoolVHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Schools school;
        TextView mTvAddress, mTvBorough, mTvContactNumber, mTvProgramSiteName;
        ImageButton mBtnMap;

        public SchoolVHolder(View itemView) {
            super(itemView);

            mTvAddress = (TextView) itemView.findViewById(R.id.tv_address);
            mTvBorough = (TextView) itemView.findViewById(R.id.tv_borough);
            mTvContactNumber = (TextView) itemView.findViewById(R.id.tv_contact_number);
            mTvProgramSiteName = (TextView) itemView.findViewById(R.id.tv_program_site_name);
            mBtnMap = (ImageButton) itemView.findViewById(R.id.btn_map);

            mBtnMap.setOnClickListener(this);
        }

        public void bind(Schools schools) {
            school = schools;
            mTvAddress.setText(schools.getAddress());
            mTvBorough.setText(schools.getBorough());
            mTvContactNumber.setText(schools.getContact_number());
            mTvProgramSiteName.setText(schools.getProgram_site_name());

        }

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("http://maps.google.co.in/maps?q=" + mTvAddress.getText() + mTvBorough.getText()));

            view.getContext().startActivity(intent);
        }
    }
}
