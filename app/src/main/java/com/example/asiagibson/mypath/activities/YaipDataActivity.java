package com.example.asiagibson.mypath.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.asiagibson.mypath.R;
import com.example.asiagibson.mypath.fragments.YaipFragment;

/**
 * Created by asiagibson on 2/18/17.
 */

public class YaipDataActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yaip_data);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        YaipFragment fragment = new YaipFragment();
        ft.add(R.id.frag_container, fragment);
        ft.commit();
    }
}
