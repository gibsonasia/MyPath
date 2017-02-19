package com.example.asiagibson.mypath.activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.asiagibson.mypath.FiveBorough;
import com.example.asiagibson.mypath.R;

public class HomeScreenActivity extends AppCompatActivity {
    Spinner ageSpinner;
    Spinner educationSpinner;
    Button yesButton;
    Button noButton;
    Button submitButton;
    RadioButton visaButton;
    RadioButton greenCardButton;
    ImageView questionImage;
    Boolean isUnder25=false;
    Boolean isOver25=false;
    Boolean hasNoGed =false;
    Boolean hasHighSchoolOrGed =false;
    Boolean hasSomeCollege=false;
    Boolean isCitizen=false;
    Boolean hasGreenCard=false;
    Boolean hasVisa=false;
    Boolean nothingSelected;
    Boolean nothingSelected2;
    Boolean nothingSelected3 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen_layout);
        ageSpinner = (Spinner) findViewById(R.id.age_spinner);
        educationSpinner = (Spinner) findViewById(R.id.education_spinner);
        yesButton = (Button) findViewById(R.id.yes_button);
        noButton = (Button) findViewById(R.id.no_button);
        visaButton = (RadioButton) findViewById(R.id.visa_button);
        greenCardButton = (RadioButton) findViewById(R.id.green_card_button);
        submitButton = (Button) findViewById(R.id.submit_button);
        questionImage = (ImageView) findViewById(R.id.question_mark_icon);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.age_array, R.layout.spinner_item1);
        ageSpinner.setAdapter(adapter);
        spinnerTasks();
        ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String ageInput = parent.getItemAtPosition(position).toString();

                switch (ageInput) {
                    case "25+":
                        Log.d("Chose", "25+");
                        isOver25 = true;
                        nothingSelected = false;
                        break;
                    case "16-24":
                        Log.d("Chose", "16-24");
                        isUnder25 = true;
                        nothingSelected = false;
                        break;
                    default:
                        Log.d("Nothing", "Chosen");
                        nothingSelected = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter educationAdapter = ArrayAdapter.createFromResource(this, R.array.education_array, R.layout.spinner_item);
        educationSpinner.setAdapter(educationAdapter);
        spinnerTasks();

        educationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String educationInput = parent.getItemAtPosition(position).toString();

                switch (educationInput) {
                    case "No GED/HS":
                        Log.d("GED", "Chosen");
                        hasNoGed = true;
                        nothingSelected2 = false;
                        break;
                    case "GED/High School Diploma":
                        Log.d("HSD", "Chosen");
                        hasHighSchoolOrGed = true;
                        nothingSelected2 = false;
                        break;
                    case "Some College":
                        Log.d("College", "Chosen");
                        hasSomeCollege = true;
                        nothingSelected2 = false;
                        break;
                    default:
                        Log.d("Nothing", "Chosen");
                        nothingSelected2 = true;
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesButton.setBackgroundColor(Color.parseColor("green"));
                isCitizen = true;
                noButton.setVisibility(View.GONE);
                nothingSelected3 = false;
            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noButton.setBackgroundColor(Color.parseColor("green"));
                yesButton.setVisibility(View.GONE);
                visaButton.setVisibility(View.VISIBLE);
                greenCardButton.setVisibility(View.VISIBLE);
                nothingSelected3 = false;
            }
        });

        visaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greenCardButton.setVisibility(View.GONE);
                isCitizen = false;
                hasVisa = true;
            }
        });

        greenCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visaButton.setVisibility(View.GONE);
                isCitizen = false;
                hasGreenCard = true;
            }
        });

        questionImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(visaButton.getContext(), R.string.question_icon_text, Toast.LENGTH_LONG).show();
            }
        });

submitButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(nothingSelected || nothingSelected2 || nothingSelected3){
            Toast.makeText(submitButton.getContext(),R.string.valid_inputs,Toast.LENGTH_LONG).show();
        }
        else{

            if(hasNoGed && isUnder25){
                Intent intent = new Intent(getBaseContext(),YaipDataActivity.class);
                startActivity(intent);
            }

            else if((!hasNoGed)&&isOver25&&(!isCitizen)){
                Intent intent = new Intent(submitButton.getContext(),EsllActivity.class);
                startActivity(intent);
            }
//            Intent intent = new Intent(getBaseContext(), FiveBorough.class);
//            Bundle bundle = new Bundle();
//            bundle.putBoolean(getResources().getString(R.string.isUnder25_ID), isUnder25);
//            bundle.putBoolean(getResources().getString(R.string.isOver25_ID),isOver25);
//            bundle.putBoolean(getResources().getString(R.string.hasGed_id), hasNoGed);
//            bundle.putBoolean(getResources().getString(R.string.hasHighSchool_id), hasHighSchoolOrGed);
//            bundle.putBoolean(getResources().getString(R.string.hasSomeCollege_id),hasSomeCollege);
//            bundle.putBoolean(getResources().getString(R.string.isCitizen_id),isCitizen);
//            bundle.putBoolean(getResources().getString(R.string.hasVisa_id),hasVisa);
//            bundle.putBoolean(getResources().getString(R.string.hasGreenCard_id),hasGreenCard);
//            bundle.putBoolean(getResources().getString(R.string.isOver25_ID),isOver25);
//
//            intent.putExtras(bundle);
//            startActivity(intent);
        }


    }
});
    }

    private void spinnerTasks() {

        String age = ageSpinner.getSelectedItem().toString();
        String education = educationSpinner.getSelectedItem().toString();

        setSpinnerToValue(ageSpinner, age);
        setSpinnerToValue(educationSpinner, education);
    }

    public void setSpinnerToValue(Spinner spinner, String value) {
        int index = 0;
        SpinnerAdapter adapter = spinner.getAdapter();
        for (int i = 0; i < adapter.getCount(); i++) {
            if (adapter.getItem(i).equals(value)) {
                index = i;
                break; // terminate loop
            }
        }
        spinner.setSelection(index);
    }
}


