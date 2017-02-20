package com.example.asiagibson.mypath.rv;

import android.content.Intent;
import android.net.Uri;
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
    public void bind(final Location location) {

        textView.setText("Program type"+ location.getProgram_type());
        mTv2.setText(location.getContact_number());
        mTv3.setText(location.getLocation_1_location());
        mTv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String formattedAddress = "geo:0,0?q=" + location.getLocation_1_location().replaceAll(" ", "+");
                Uri uri = Uri.parse(formattedAddress);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                view.getContext().startActivity(intent);
            }
        });

    }
}
