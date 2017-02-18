package com.example.asiagibson.mypath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FiveBorough extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_borough);
    }

    public void onClickButtons(View v){

        Intent intent = new Intent(this, ThirdActivity.class);

        switch (v.getId()){

            case R.id.manhattan:
                intent.putExtra("borough", "Manhattan");
                break;
            case R.id.brooklyn:
                intent.putExtra("borough", "Brooklyn");
                break;
            case R.id.queens:
                intent.putExtra("borough", "Queens");
                break;
            case R.id.bronx:
                intent.putExtra("borough", "Bronx");
                break;
            case R.id.staten_island:
                intent.putExtra("borough", "Staten Island");
                break;
        }
        startActivity(intent);
    }
}
