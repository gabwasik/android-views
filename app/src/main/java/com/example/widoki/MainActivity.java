package com.example.widoki;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private SwitchMaterial switchCompatName;
    private CheckBox checkBox;
    private RadioGroup radioGroupGender;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        switchCompatName = findViewById(R.id.switchCompatName);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        checkBox = findViewById(R.id.checkBox);

        Button buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(view -> openSecondActivity());
    }

    private void openSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        Bundle bundle = new Bundle();

        // imię i nazwisko
        bundle.putString("NAME", String.valueOf(editTextName.getText()));

        // skracanie nazwiska
        bundle.putBoolean("NAME_SHORTEN", switchCompatName.isChecked());

        // płeć
        int buttonId = radioGroupGender.getCheckedRadioButtonId();
        if (buttonId != -1) {
            RadioButton selectedButton = findViewById(buttonId);
            bundle.putString("GENDER", (String) selectedButton.getText());
        }

        // "wiek"
        bundle.putBoolean("ADULT", checkBox.isChecked());

        intent.putExtras(bundle);
        startActivity(intent);
    }
}
