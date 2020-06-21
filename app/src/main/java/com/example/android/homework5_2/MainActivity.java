package com.example.android.homework5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    TextInputEditText mPersonName;
    TextInputEditText mPersonPatronymic;
    TextInputEditText mPersonSurname;
    TextInputEditText mPersonAge;
    TextInputLayout mNameInputLayout;
    TextInputLayout mPatronymicInputLayout;
    TextInputLayout mSurnameInputLayout;
    TextInputLayout mAgeInputLayout;
    Button mSaveButton;
    Button mVitalStatisticButton;
    Button mPressureButton;
    Person person;
    TreeSet<Person> personTreeSet;

    int personAge;
    String personName;
    String personPatronymic;
    String personSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPersonName = (TextInputEditText) findViewById(R.id.nameTextInput);
        mPersonPatronymic = (TextInputEditText) findViewById(R.id.patronymicTextInput);
        mPersonSurname = (TextInputEditText) findViewById(R.id.surnameTextInput);
        mPersonAge = (TextInputEditText) findViewById(R.id.ageTextInput);
        mSaveButton = (Button) findViewById(R.id.saveBtn);
        mVitalStatisticButton = (Button) findViewById(R.id.vitalStatisticsBtn);
        mPressureButton = (Button) findViewById(R.id.pressureBtn);
        mNameInputLayout = (TextInputLayout) findViewById(R.id.nameInputLayout);
        mPatronymicInputLayout = (TextInputLayout) findViewById(R.id.patronymicInputLayout);
        mSurnameInputLayout = (TextInputLayout) findViewById(R.id.surnameInputLayout);
        mAgeInputLayout = (TextInputLayout) findViewById(R.id.ageInputLayout);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNameInputLayout.setError("");
                mPatronymicInputLayout.setError("");
                mSurnameInputLayout.setError("");
                mAgeInputLayout.setError("");
                int i = 0;

                if (mPersonName.getText().length() == 0) {
                    mNameInputLayout.setError(getString(R.string.empty_field));
                } else {
                    personName = Objects.requireNonNull(mPersonName.getText()).toString();
                    i++;
                }

                if (mPersonPatronymic.getText().length() == 0) {
                    mPatronymicInputLayout.setError(getString(R.string.empty_field));
                } else {
                    personPatronymic = mPersonPatronymic.getText().toString();
                    i++;
                }

                if (mPersonSurname.getText().length() == 0) {
                    mSurnameInputLayout.setError(getString(R.string.empty_field));
                } else {
                    personSurname = Objects.requireNonNull(mPersonSurname.getText()).toString();
                    i++;
                }

                if (mPersonAge.getText().length() == 0) {
                    mAgeInputLayout.setError(getString(R.string.empty_field));
                } else {
                    personAge = Integer.parseInt(Objects.requireNonNull(mPersonAge.getText()).toString());
                    i++;
                }

                if (i == 4) {
                    person = new Person(personName, personPatronymic, personSurname, personAge);
                    personTreeSet = new TreeSet<>();
                    if (personTreeSet.add(person)) {
                        Toast toast = Toast.makeText(MainActivity.this, R.string.toast_message, Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        Toast toast = Toast.makeText(MainActivity.this, R.string.toast_error_message, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
            }
        });

        mVitalStatisticButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VitalStatisticsActivity.class);
                startActivity(intent);
            }
        });

        mPressureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });
    }
}
