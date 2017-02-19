package com.example.asiagibson.mypath.rv;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asiagibson.mypath.R;
import com.example.asiagibson.mypath.model.Location;

/**
 * Created by asiagibson on 2/18/17.
 */

public class YaipViewHolder extends RecyclerView.ViewHolder {

    TextView textView,mTv2, mTv3;


    public YaipViewHolder(View view) {
        super(view);
        textView = (TextView) itemView.findViewById(R.id.yaip_tv);
        mTv2 = (TextView) itemView.findViewById(R.id.tv2);
        mTv3 = (TextView) itemView.findViewById(R.id.tv3);

    }
    public void bind(Location location) {

        textView.setText(location.getProgram_type());
        mTv2.setText(location.getGrade_level_age_group());
        mTv3.setText(location.getBorough_community());

    }
}
