package com.example.asiagibson.mypath.rv;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.asiagibson.mypath.R;
import com.example.asiagibson.mypath.model.EsllData;

/**
 * Created by asiagibson on 2/18/17.
 */

public class EsllViewHolder extends RecyclerView.ViewHolder {

    TextView tv1,tv2,tv3,tv4;

    public EsllViewHolder(View view) {
        super(view);

        tv1 = (TextView) itemView.findViewById(R.id.esll_tv1);
        tv2 = (TextView) itemView.findViewById(R.id.esll_tv2);
        tv3 = (TextView) itemView.findViewById(R.id.esll_tv3);
        tv4 = (TextView) itemView.findViewById(R.id.esll_tv4);

    }

    public void bind(final EsllData esllData) {
        tv1.setText(esllData.getSite_name());
        tv2.setText(esllData.getLocation_1_location());

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String formattedAddress = "geo:0,0?q=" + esllData.getLocation_1_location().replaceAll(" ", "+");
                Uri uri = Uri.parse(formattedAddress);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                view.getContext().startActivity(intent);
            }
        });

        tv3.setText(esllData.getContact_number());
        tv4.setText(esllData.getProgram());


    }
}
