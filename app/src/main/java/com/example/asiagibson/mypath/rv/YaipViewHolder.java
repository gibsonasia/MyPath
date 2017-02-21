package com.example.asiagibson.mypath.rv;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asiagibson.mypath.R;
import com.example.asiagibson.mypath.model.Location;

/**
 * Created by asiagibson on 2/18/17.
 */

public class YaipViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

     ImageButton mBtnMap;
    TextView textView, mTv2, mTv3;


    public YaipViewHolder(View view) {
        super(view);
        textView = (TextView) itemView.findViewById(R.id.yaip_tv);
        mTv2 = (TextView) itemView.findViewById(R.id.tv2);
        mTv3 = (TextView) itemView.findViewById(R.id.tv3);
        mBtnMap = (ImageButton) itemView.findViewById(R.id.btn_map);

        mBtnMap.setOnClickListener(this);

    }

    public void bind(final Location location) {

        textView.setText("Program type" + location.getProgram_type());
        mTv2.setText(location.getContact_number());
        mTv3.setText(location.getLocation_1_location());

    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.co.in/maps?q=" + mTv3.getText()));

        view.getContext().startActivity(intent);
    }
}
