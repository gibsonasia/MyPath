package com.example.asiagibson.mypath.rv;

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

    public void bind(EsllData esllData) {
        tv1.setText(esllData.getSite_name());
        tv2.setText(esllData.getProgram_type());
        tv3.setText(esllData.getGrade_level_age_group());
        tv4.setText(esllData.getContact_number());


    }
}
