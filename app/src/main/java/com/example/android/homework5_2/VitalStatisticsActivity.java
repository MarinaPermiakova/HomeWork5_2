package com.example.android.homework5_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.TreeSet;

public class VitalStatisticsActivity extends AppCompatActivity {

    TextInputEditText mWeight;
    TextInputEditText mPaces;
    Button mSaveButton;
    Button mMainButton;
    Button mPressureButton;
    TextInputLayout mWeightInputLayout;
    TextInputLayout mPacesInputLayout;
    VitalStatistics vitalStatistics;
    TreeSet<VitalStatistics> vitalStatisticsTreeSet;
    float weight;
    int paces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vital_statistics);
        mWeight = (TextInputEditText) findViewById(R.id.weightTextInput);
        mPaces = (TextInputEditText) findViewById(R.id.pacesTextInput);
        mSaveButton = (Button) findViewById(R.id.saveVitalStatisticBtn);
        mMainButton = (Button) findViewById(R.id.mainBtn2);
        mPressureButton = (Button) findViewById(R.id.pressureBtn2);
        mWeightInputLayout = (TextInputLayout) findViewById(R.id.weightInputLayout);
        mPacesInputLayout = (TextInputLayout) findViewById(R.id.pacesInputLayout);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWeightInputLayout.setError("");
                mPacesInputLayout.setError("");
                int i = 0;

                if(mWeight.getText().length() == 0){
                    mWeightInputLayout.setError(getString(R.string.empty_field));
                } else {
                    weight = Float.parseFloat(mWeight.getText().toString());
                    i++;
                }

                if(mPaces.getText().length() == 0){
                    mPacesInputLayout.setError(getString(R.string.empty_field));
                } else{
                    paces = Integer.parseInt(mPaces.getText().toString());
                    i++;
                }

                if(i == 2){
                    vitalStatistics = new VitalStatistics(weight, paces);
                    vitalStatisticsTreeSet = new TreeSet<>();
                    if (vitalStatisticsTreeSet.add(vitalStatistics)) {
                        Toast toast = Toast.makeText(VitalStatisticsActivity.this, R.string.toast_message, Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        Toast toast = Toast.makeText(VitalStatisticsActivity.this, R.string.toast_error_message, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });

        mMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VitalStatisticsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mPressureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VitalStatisticsActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });

    }
}