package com.example.asiagibson.mypath.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.asiagibson.mypath.R;

/**
 * Created by asiagibson on 2/20/17.
 */

public class BorosEsllActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boro_search);
    }

    public void onClickButtons(View v) {

        Intent intent = new Intent(this, EsllActivity.class);
        switch (v.getId()) {

            case R.id.manhattan:
                intent.putExtra("borough_community", "New York");
                break;
            case R.id.brooklyn:
                intent.putExtra("borough_community", "Brooklyn");
                break;
            case R.id.queens:
                intent.putExtra("borough_community", "Queens");
                break;
            case R.id.bronx:
                intent.putExtra("borough_community", "Bronx");
                break;
            case R.id.staten_island:
                intent.putExtra("borough_community", "Staten Island");
                break;
        }
        startActivity(intent);
    }

}
