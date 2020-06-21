package com.example.android.homework5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PressureActivity extends AppCompatActivity {

    TextInputEditText mHighPressure;
    TextInputEditText mLowPressure;
    TextInputEditText mPulse;
    CheckBox mTachycardia;
    TextInputEditText mDate;

    Button mSaveButton;
    Button mMainButton;
    Button mVitalStatisticsButton;

    TextInputLayout mHighPressureInputLayout;
    TextInputLayout mLowPressureInputLayout;
    TextInputLayout mPulseInputLayout;
    TextInputLayout mDateInputLayout;

    int highPressure;
    int lowPressure;
    int pulse;
    Date date;
    boolean tachycardia;

    Pressure pressure;
    Map<Date, Pressure> pressureTreeMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        mHighPressure = (TextInputEditText) findViewById(R.id.highPressureTextInput);
        mLowPressure = (TextInputEditText) findViewById(R.id.lowPressureTextInput);
        mPulse = (TextInputEditText) findViewById(R.id.pulseTextInput);
        mTachycardia = (CheckBox) findViewById(R.id.tachycardiaCheckBox);
        mDate = (TextInputEditText) findViewById(R.id.dateTextInput);
        mSaveButton = (Button) findViewById(R.id.savePressureBtn);
        mMainButton = (Button) findViewById(R.id.mainBtn);
        mVitalStatisticsButton = (Button) findViewById(R.id.vitalStatisticsBtn2);

        mHighPressureInputLayout = (TextInputLayout) findViewById(R.id.highPressureInputLayout);
        mLowPressureInputLayout = (TextInputLayout) findViewById(R.id.lowPressureInputLayout);
        mPulseInputLayout = (TextInputLayout) findViewById(R.id.pulseInputLayout);
        mDateInputLayout = (TextInputLayout) findViewById(R.id.dateInputLayout);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHighPressureInputLayout.setError("");
                mLowPressureInputLayout.setError("");
                mDateInputLayout.setError("");
                mPulseInputLayout.setError("");
                int i = 0;

                if (mHighPressure.getText().length() == 0) {
                    mHighPressureInputLayout.setError(getString(R.string.empty_field));
                } else {
                    highPressure = Integer.parseInt(mHighPressure.getText().toString());
                    i++;
                }

                if (mLowPressure.getText().length() == 0) {
                    mLowPressureInputLayout.setError(getString(R.string.empty_field));
                } else {
                    lowPressure = Integer.parseInt(mLowPressure.getText().toString());
                    i++;
                }

                if (mPulse.getText().length() == 0) {
                    mPulseInputLayout.setError(getString(R.string.empty_field));
                } else {
                    pulse = Integer.parseInt(mPulse.getText().toString());
                    i++;
                }

                if (mDate.getText().length() == 0) {
                    mDateInputLayout.setError(getString(R.string.empty_field));
                } else {
                    SimpleDateFormat sdf = new SimpleDateFormat(getString(R.string.time_format));
                    try {
                        date = sdf.parse(mDate.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                        mDateInputLayout.setError(getString(R.string.time_format_error));
                    }
                    i++;
                }

                tachycardia = mTachycardia.isChecked();

                if (i == 4) {
                    pressure = new Pressure(highPressure, lowPressure, pulse, tachycardia);
                    if (!pressureTreeMap.containsKey(date)) {
                        pressureTreeMap.put(date, pressure);
                        Toast toast = Toast.makeText(PressureActivity.this, R.string.toast_message, Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        Toast toast = Toast.makeText(PressureActivity.this, R.string.toast_error_message, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });

        mMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PressureActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mVitalStatisticsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PressureActivity.this, VitalStatisticsActivity.class);
                startActivity(intent);
            }
        });
    }
}